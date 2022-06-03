package com.nanofly.nanoApi.service;

import com.nanofly.nanoApi.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    Optional<Airport> getAirport(Long id);
    List<Airport> getAll();
    Airport create(Airport airport);
    Optional<Airport> delete(Long id);
}
