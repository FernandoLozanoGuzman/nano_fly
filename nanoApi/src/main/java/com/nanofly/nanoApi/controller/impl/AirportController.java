package com.nanofly.nanoApi.controller.impl;

import com.nanofly.nanoApi.controller.AirportAPI;
import com.nanofly.nanoApi.model.Airport;
import com.nanofly.nanoApi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController implements AirportAPI {

    @Autowired
    private AirportService airportService;

    @Override
    @GetMapping("/{id}")
    public Optional<Airport> getAirport(@PathVariable Long id) {
        return airportService.getAirport(id);
    }

    @Override
    @GetMapping("/all")
    public List<Airport> getAll() {
        return airportService.getAll();
    }

    @Override
    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return airportService.create(airport);
    }

    @Override
    @DeleteMapping("/{id}")
    public Optional<Airport> delete(@PathVariable Long id) {
        return airportService.delete(id);
    }
}
