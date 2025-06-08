package fr.miage.lroux.compositestationvoiture.repository;

import fr.miage.lroux.compositestationvoiture.dto.GestionVoiture;
import fr.miage.lroux.compositestationvoiture.dto.StationWithVoiture;

public interface RepoStationVoiture {

    StationWithVoiture getStationWithVoiture(long idStation) throws Exception;

    GestionVoiture createVoiture(long idStation, GestionVoiture voiture) throws Exception;

}