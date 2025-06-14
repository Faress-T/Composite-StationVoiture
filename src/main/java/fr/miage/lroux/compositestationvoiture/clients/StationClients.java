package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("station")
public interface StationClients {

    @RequestMapping(method = RequestMethod.GET, value = "/api/station/{id}", produces = "application/json")
    Station getStation(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/api/station/create", produces = "application/json")
    Station postStation(@RequestBody Station station);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/station/add/{stationId}", produces = "application/json")
    void updateStationAddCar(@PathVariable Long stationId);

}
