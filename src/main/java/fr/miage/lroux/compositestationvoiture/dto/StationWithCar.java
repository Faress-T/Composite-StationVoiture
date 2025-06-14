package fr.miage.lroux.compositestationvoiture.dto;

import java.util.List;

public class StationWithCar extends Station {

    private List<Car> voitures;

    public StationWithCar(Station station, List<Car> voitures) {
        super(station.getStationId(), station.getPosition(), station.getNbPlaces(), station.getNbPlacesTaken(), station.getNbPlacesFree());
        this.voitures = voitures;
    }

    public List<Car> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Car> voitures) {
        this.voitures = voitures;
    }
}
