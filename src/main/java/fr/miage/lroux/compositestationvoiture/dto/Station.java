package fr.miage.lroux.compositestationvoiture.dto;

import java.io.Serializable;
import java.util.List;

public class Station implements Serializable {
    private long stationId;
    private List<Double> localisation;
    private int nbPlaces;
    private int nbPlacesTaken;
    private int nbPlacesFree;

    public Station() {
    }

    public Station(long stationId, List<Double> localisation, int nbPlaces, int nbPlacesTaken, int nbPlacesFree) {
        this.stationId = stationId;
        this.localisation = localisation;
        this.nbPlaces = nbPlaces;
        this.nbPlacesTaken = nbPlacesTaken;
        this.nbPlacesFree = nbPlacesFree;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public List<Double> getLocalisation() {
        return localisation;
    }

    public void setLocalisation(List<Double> localisation) {
        this.localisation = localisation;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getNbPlacesTaken() {
        return nbPlacesTaken;
    }

    public void setNbPlacesTaken(int nbPlacesTaken) {
        this.nbPlacesTaken = nbPlacesTaken;
    }

    public int getNbPlacesFree() {
        return nbPlacesFree;
    }

    public void setNbPlacesFree(int nbPlacesFree) {
        this.nbPlacesFree = nbPlacesFree;
    }
}
