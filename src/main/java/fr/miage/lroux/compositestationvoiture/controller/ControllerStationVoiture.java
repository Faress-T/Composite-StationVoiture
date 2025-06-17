package fr.miage.lroux.compositestationvoiture.controller;

import fr.miage.lroux.compositestationvoiture.dto.Car;
import fr.miage.lroux.compositestationvoiture.dto.Station;
import fr.miage.lroux.compositestationvoiture.dto.StationWithCar;
import fr.miage.lroux.compositestationvoiture.repository.RepoStationVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stationCar/")
public class ControllerStationVoiture {

    @Autowired
    RepoStationVoiture repoStationVoiture;

    @GetMapping("{stationId}")
    public StationWithCar getStationWithVoiture(@PathVariable long stationId) throws Exception {
        return repoStationVoiture.getStationWithCar(stationId);
    }

    @PostMapping("car/{stationId}")
    public Car createVoiture(@PathVariable("stationId") Long stationId, @RequestBody Car voiture) throws Exception {
        return repoStationVoiture.createCar(stationId,voiture);
    }

    @PostMapping("station")
    public Station createStation(@RequestBody Station station) throws Exception {
        return repoStationVoiture.createStation(station);
    }
}
