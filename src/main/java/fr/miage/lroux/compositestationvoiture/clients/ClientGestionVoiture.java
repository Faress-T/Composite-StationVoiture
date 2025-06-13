package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.GestionVoiture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("car")
public interface ClientGestionVoiture {
    @RequestMapping(method = RequestMethod.GET, value = "/api/car/{id}", produces = "application/json")
    GestionVoiture getVoiture(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/car/cars/{stationId}", produces = "application/json")
    List<GestionVoiture> getVoituresByStation(@PathVariable Long stationId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/car/create", produces = "application/json")
    GestionVoiture postVoiture(@RequestBody GestionVoiture gestionVoiture);

    @RequestMapping(value = "/api/car/delete/{id}", produces = "application/json")
    GestionVoiture deleteVoiture(@PathVariable Long id);
}
