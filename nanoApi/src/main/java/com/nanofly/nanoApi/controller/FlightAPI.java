package com.nanofly.nanoApi.controller;

import com.nanofly.nanoApi.model.Flight;

import java.nio.channels.FileLock;
import java.util.List;
import java.util.Optional;

public interface FlightAPI {

    Optional<Flight> getFlight(Long id);
    List<Flight> getAll();
    Flight create(Flight flight);
    Optional<Flight> delete(Long id);
    List<Flight> searchByAirports(String airportOrigin, String airportDestine);
    List<Flight> searchByAirport(String airportOrigin, String airportDestine);
}
