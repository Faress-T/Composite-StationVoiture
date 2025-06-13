package fr.miage.lroux.compositestationvoiture.service;

import feign.FeignException;
import fr.miage.lroux.compositestationvoiture.clients.ClientGestionVoiture;
import fr.miage.lroux.compositestationvoiture.clients.ClientStations;
import fr.miage.lroux.compositestationvoiture.dto.GestionVoiture;
import fr.miage.lroux.compositestationvoiture.dto.Station;
import fr.miage.lroux.compositestationvoiture.dto.StationWithVoiture;
import fr.miage.lroux.compositestationvoiture.repository.RepoStationVoiture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceStationVoiture implements RepoStationVoiture {

    private final ClientGestionVoiture clientGestionVoiture;

    private final ClientStations clientStation;

    public ServiceStationVoiture(ClientGestionVoiture clientGestionVoiture, ClientStations clientStation, ClientGestionVoiture clientGestionVoiture1, ClientStations clientStation1) {
        this.clientGestionVoiture = clientGestionVoiture1;
        this.clientStation = clientStation1;
    }

    @Override
    public StationWithVoiture getStationWithVoiture(long stationId) throws Exception {
        Station station = null;
        try{
            station = clientStation.getStation(stationId);
        } catch (FeignException.NotFound e){
            throw new Exception();
        }

        List<GestionVoiture> voitures = clientGestionVoiture.getVoituresByStation(station.getStationId());

        StationWithVoiture swv = new StationWithVoiture();

        swv.setStationId(station.getStationId());
        swv.setNbPlaces(station.getNbPlaces());
        swv.setPosition(station.getPosition());
        swv.setNbPlacesFree(station.getNbPlacesFree());
        swv.setNbPlacesTaken(station.getNbPlacesTaken());
        swv.setVoitures(voitures);

        return swv;
    }

    @Override
    public GestionVoiture createVoiture(long idStation, GestionVoiture optVoiture) throws Exception{
        Station station = null;
        try {
            station = this.clientStation.getStation(idStation);
        } catch (FeignException.NotFound e) {
            throw new Exception();
        }

        GestionVoiture voiture = null;

        try {
            optVoiture.setStationId(station.getStationId());
            voiture = clientGestionVoiture.postVoiture(optVoiture);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return voiture;
    }

}