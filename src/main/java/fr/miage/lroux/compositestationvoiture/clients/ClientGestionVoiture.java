package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.GestionVoiture;
import fr.miage.lroux.compositestationvoiture.dto.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("car")
public interface ClientGestionVoiture {
    @RequestMapping(method = RequestMethod.GET, value = "/api/car/{id}", produces = "application/json")
    GestionVoiture getVoiture(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/car/cars", produces = "application/json")
    List<GestionVoiture> getVoitures(@RequestParam("station") Long idStation);

    @RequestMapping(method = RequestMethod.POST, value = "/api/car/create", produces = "application/json")
    GestionVoiture postVoiture(@RequestBody GestionVoiture gestionVoiture);

    @RequestMapping(value = "/api/car/delete/{id}", produces = "application/json")
    GestionVoiture deleteVoiture(@PathVariable Long id);
}
