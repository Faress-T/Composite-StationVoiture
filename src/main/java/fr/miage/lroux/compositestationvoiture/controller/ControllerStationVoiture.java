package fr.miage.lroux.compositestationvoiture.controller;

import fr.miage.lroux.compositestationvoiture.dto.GestionVoiture;
import fr.miage.lroux.compositestationvoiture.dto.StationWithVoiture;
import fr.miage.lroux.compositestationvoiture.repository.RepoStationVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stationCar/")
public class ControllerStationVoiture {

    @Autowired
    RepoStationVoiture repoStationVoiture;

    @GetMapping("{stationId}")
    public StationWithVoiture getStationWithVoiture(@PathVariable("stationId") long stationId) throws Exception {
        return repoStationVoiture.getStationWithVoiture(stationId);
    }

    @PostMapping("{stationId}")
    public GestionVoiture createVoiture(@PathVariable("stationId") Long stationId, @RequestBody GestionVoiture voiture) throws Exception {
        return repoStationVoiture.createVoiture(stationId,voiture);
    }

}
