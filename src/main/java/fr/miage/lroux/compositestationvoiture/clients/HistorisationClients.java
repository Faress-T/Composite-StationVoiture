package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.Car;
import fr.miage.lroux.compositestationvoiture.dto.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "statistique")
public interface HistorisationClients {

    @RequestMapping(method = RequestMethod.POST, value = "/api/snapshots/car/", produces = "application/json")
    Car postCarHistorisation(@RequestBody Car car);

    @RequestMapping(method = RequestMethod.POST, value = "/api/snapshots/station/", produces = "application/json")
    Station postStationHistorisation(@RequestBody Station station);
}
