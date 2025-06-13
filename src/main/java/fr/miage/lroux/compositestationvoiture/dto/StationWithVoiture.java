package fr.miage.lroux.compositestationvoiture.dto;

import java.util.List;

public class StationWithVoiture extends Station {

    private List<GestionVoiture> voitures;

    public StationWithVoiture(Station station, List<GestionVoiture> voitures) {
        super(station.getStationId(), station.getPosition(), station.getNbPlaces(), station.getNbPlacesTaken(), station.getNbPlacesFree());
        this.voitures = voitures;
    }

    public StationWithVoiture() {

    }

    public List<GestionVoiture> getVoituresByStation() {
        return voitures;
    }

    public void setVoitures(List<GestionVoiture> voitures) {
        this.voitures = voitures;
    }
}
