package fr.miage.lroux.compositestationvoiture.service;

import feign.FeignException;
import fr.miage.lroux.compositestationvoiture.clients.HistorisationClients;
import fr.miage.lroux.compositestationvoiture.clients.StationClients;
import fr.miage.lroux.compositestationvoiture.clients.CarClients;
import fr.miage.lroux.compositestationvoiture.dto.Car;
import fr.miage.lroux.compositestationvoiture.dto.Station;
import fr.miage.lroux.compositestationvoiture.dto.StationWithCar;
import fr.miage.lroux.compositestationvoiture.repository.RepoStationVoiture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceStationVoiture implements RepoStationVoiture {

    /**
     * Clients for accessing car and station services.
     */
    private final CarClients carClients;

    private final HistorisationClients historisationClients;

    private final StationClients clientStation;

    public ServiceStationVoiture(CarClients carClients, StationClients clientStation, HistorisationClients historisationClients) {
        this.carClients = carClients;
        this.clientStation = clientStation;
        this.historisationClients = historisationClients;
    }

    /**
     * Retrieves a station along with its cars by station ID.
     *
     * @param stationId the ID of the station
     * @return StationWithCar object containing station details and list of cars
     * @throws Exception if an error occurs while retrieving the station or cars
     */
    @Override
    public StationWithCar getStationWithCar(long stationId) throws Exception {
        Station station = checkStationExistOrThrow(stationId);

        List<Car> cars = getCarByStations(stationId);

        return new StationWithCar(station, cars);
    }

    /**
     * Creates a new car at a specified station.
     *
     * @param idStation the ID of the station where the car will be created
     * @param car the Car object to create
     * @return Created Car object
     * @throws Exception if an error occurs while creating the car or updating the station
     */
    @Override
    public Car createCar(long idStation, Car car) throws Exception {
        Station station = checkStationExistOrThrow(idStation);

        car.setStationId(station.getStationId());
        Car carReturn = createCarOrThrow(car);

        updateStationAddCar(idStation);

        updateCarStationIdOrThrow( carReturn.getCarId(),  idStation);

        historisationClients.postCarHistorisation(carReturn);

        return carReturn;
    }

    public Station createStation(Station station) throws Exception {
        try {
            historisationClients.postStationHistorisation(station);
            return clientStation.postStation(station);
        } catch (FeignException e) {
            throw new RuntimeException("Failed to create station", e);
        }
    }

    private Station checkStationExistOrThrow(long stationId) throws Exception {
        try {
            return clientStation.getStation(stationId);
        } catch (FeignException.NotFound e) {
            throw new Exception("Station not found with id: " + stationId);
        }
    }

    private void updateCarStationIdOrThrow(long carId, long stationId) throws Exception {
        try {
            carClients.updateStationId(carId, stationId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update car with station ID", e);
        }
    }

    private void updateStationAddCar(long stationId) throws Exception {
        try {
            clientStation.updateStationAddCar(stationId);
        } catch (FeignException.NotFound e) {
            throw new Exception("Failed to update station with added car", e);
        }
    }

    private Car createCarOrThrow(Car car) {
        try {
            return carClients.postCar(car);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create car", e);
        }
    }

    private List<Car> getCarByStations(long stationId) throws Exception {
        try {
            return carClients.getCarByStations(stationId);
        } catch (FeignException.NotFound e) {
            throw new Exception("No cars found for station with id: " + stationId);
        }
    }
}
