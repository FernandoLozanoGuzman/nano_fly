package com.nanofly.nanoApi.service;

import com.nanofly.nanoApi.model.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    Optional<Airline> getAirline(Long id);
    List<Airline> getAll();
    Airline create(Airline airline);
    Optional<Airline> delete(Long id);
}
