package com.nanofly.nanoApi.controller.impl;

import com.nanofly.nanoApi.controller.AirplaneAPI;
import com.nanofly.nanoApi.model.Airplane;
import com.nanofly.nanoApi.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplane")
public class AirplaneController implements AirplaneAPI {

    @Autowired
    private AirplaneService airplaneService;

    @Override
    @GetMapping("/{id}")
    public Optional<Airplane> getAirplane(@PathVariable Long id) {
        return airplaneService.getAirplane(id);
    }

    @Override
    @GetMapping("/all")
    public List<Airplane> getAll() {
        return airplaneService.getAll();
    }

    @Override
    @PostMapping
    public Airplane create(@RequestBody Airplane airplane) {
        return airplaneService.create(airplane);
    }

    @Override
    @DeleteMapping("/{id}")
    public Optional<Airplane> delete(@PathVariable Long id) {
        return airplaneService.delete(id);
    }
}
