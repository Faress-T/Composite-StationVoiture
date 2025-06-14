package fr.miage.lroux.compositestationvoiture.dto;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {
    private long carId;
    private String brand;
    private String model;
    private double batteryLevel;
    private double kilometresTravelled;
    private int numberOfSeats;
    private boolean used;
    private List<Double> localisation;
    private long stationId;

    public Car() {}

    public Car(long carId, String brand, String model, double batteryLevel, double kilometresTravelled, int numberOfSeats, boolean used, List<Double> localisation, long stationId) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
        this.kilometresTravelled = kilometresTravelled;
        this.numberOfSeats = numberOfSeats;
        this.used = used;
        this.localisation = localisation;
        this.stationId = stationId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getKilometresTravelled() {
        return kilometresTravelled;
    }

    public void setKilometresTravelled(double kilometresTravelled) {
        this.kilometresTravelled = kilometresTravelled;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public List<Double> getLocalisation() {
        return localisation;
    }

    public void setLocalisation(List<Double> localisation) {
        this.localisation = localisation;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }
}
