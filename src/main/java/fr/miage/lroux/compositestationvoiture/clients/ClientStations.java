package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient("station")
public interface ClientStations {

    @RequestMapping(method = RequestMethod.GET, value = "/api/station/{id}", produces = "application/json")
    Station getStation(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/api/station/create", produces = "application/json")
    Station postStation(@RequestBody Station station);

    @DeleteMapping(value = "/{id}", produces = "application/json")
    Station deleteStation(@PathVariable Long id);
}
