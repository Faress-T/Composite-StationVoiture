package fr.miage.lroux.compositestationvoiture.repository;

import fr.miage.lroux.compositestationvoiture.dto.Car;
import fr.miage.lroux.compositestationvoiture.dto.StationWithCar;

public interface RepoStationVoiture {

    StationWithCar getStationWithCar(long idStation) throws Exception;

    Car createCar(long idStation, Car voiture) throws Exception;

}