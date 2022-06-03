package com.nanofly.nanoApi.service;

import com.nanofly.nanoApi.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Optional<Flight> getFlight(Long id);
    List<Flight> getAll();
    Flight create(Flight flight);
    Optional<Flight> delete(Long id);
    List<Flight> searchByAirports(String airportOrigin, String airportDestine);
    List<Flight> searchByAirport(String airportOrigin, String airportDestine);

}
