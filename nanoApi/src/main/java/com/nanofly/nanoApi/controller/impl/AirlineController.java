package com.nanofly.nanoApi.controller.impl;

import com.nanofly.nanoApi.controller.AirlineAPI;
import com.nanofly.nanoApi.model.Airline;
import com.nanofly.nanoApi.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline")
public class AirlineController implements AirlineAPI {

    @Autowired
    private AirlineService airlineService;

    @Override
    @GetMapping("/{id}")
    public Optional<Airline> getAirline(@PathVariable Long id) {
        return airlineService.getAirline(id);
    }

    @Override
    @GetMapping("/all")
    public List<Airline> getAll() {
        return airlineService.getAll();
    }

    @Override
    @PostMapping
    public Airline create(@RequestBody Airline airline) {
        return airlineService.create(airline);
    }

    @Override
    @DeleteMapping("/{id}")
    public Optional<Airline> delete(@PathVariable Long id) {
        return airlineService.delete(id);
    }
}
