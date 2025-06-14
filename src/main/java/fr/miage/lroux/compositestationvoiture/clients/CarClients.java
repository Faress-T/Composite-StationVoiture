package fr.miage.lroux.compositestationvoiture.clients;

import fr.miage.lroux.compositestationvoiture.dto.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("car")
public interface CarClients {
    @RequestMapping(method = RequestMethod.GET, value = "/api/car/{id}", produces = "application/json")
    Car getCar(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/car/cars", produces = "application/json")
    List<Car> getCars(@RequestParam("station") Long idStation);

    @RequestMapping(method = RequestMethod.POST, value = "/api/car/create", produces = "application/json")
    Car postCar(@RequestBody Car car);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/car/{id}", produces = "application/json")
    Car updateStationId(@PathVariable long id, @RequestBody long stationId);

    @RequestMapping(method = RequestMethod.GET, value = "/api/car/cars/{stationId}", produces = "application/json")
    List<Car> getCarByStations(@PathVariable long stationId);
}
