package com.nanofly.nanoApi.controller;

import com.nanofly.nanoApi.model.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineAPI {
    Optional<Airline> getAirline(Long id);
    List<Airline> getAll();
    Airline create(Airline airline);
    Optional<Airline> delete(Long id);
}
