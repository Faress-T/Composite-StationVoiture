package fr.miage.lroux.compositestationvoiture.dto;

import java.util.List;

public class StationWithVoiture extends Station {

    private GestionVoiture voiture;

    private List<GestionVoiture> voitures;

    public StationWithVoiture(Station station, List<GestionVoiture> voitures) {
        super(station.getId(), station.getPosition(), station.getNbPlaces(), station.getNbPlacesTaken(), station.getNbPlacesFree());
        this.voitures = voitures;
    }

}
