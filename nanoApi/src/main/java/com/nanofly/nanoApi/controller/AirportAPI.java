package com.nanofly.nanoApi.controller;

import com.nanofly.nanoApi.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportAPI {
    Optional<Airport> getAirport(Long id);
    List<Airport> getAll();
    Airport create(Airport airport);
    Optional<Airport> delete(Long id);
}
