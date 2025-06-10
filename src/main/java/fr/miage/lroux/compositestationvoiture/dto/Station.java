package fr.miage.lroux.compositestationvoiture.dto;

import java.io.Serializable;

public class Station implements Serializable {
    private long stationId;
    private String position;
    private int nbPlaces;
    private int nbPlacesTaken;
    private int nbPlacesFree;

    public Station() {
    }

    public Station(long stationId, String position, int nbPlaces, int nbPlacesTaken, int nbPlacesFree) {
        this.stationId = stationId;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
