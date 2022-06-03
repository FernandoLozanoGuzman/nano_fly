package com.nanofly.nanoApi.controller.impl;

import com.nanofly.nanoApi.controller.FlightAPI;
import com.nanofly.nanoApi.model.Flight;
import com.nanofly.nanoApi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController implements FlightAPI {

    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    @Override
    public Optional<Flight> getFlight(@PathVariable Long id) {
        return flightService.getFlight(id);
    }

    @Override
    @GetMapping("/all")
    public List<Flight> getAll() {
        return flightService.getAll();
    }

    @Override
    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @Override
    @DeleteMapping("/{id}")
    public Optional<Flight> delete(@PathVariable Long id) {
        return flightService.delete(id);
    }

    @Override
    @GetMapping("/airports")
    public List<Flight> searchByAirports(@RequestParam("airportOrigin") String airportOrigin, @RequestParam("airportDestine") String airportDestine) {
        return flightService.searchByAirports(airportOrigin,airportDestine);
    }

    @Override
    @GetMapping("/airportDestine")
    public List<Flight> searchByAirport(@RequestParam("airportOrigin") String airportOrigin, @RequestParam("airportDestine") String airportDestine){
        return flightService.searchByAirport(airportOrigin,airportDestine);
    }

}
