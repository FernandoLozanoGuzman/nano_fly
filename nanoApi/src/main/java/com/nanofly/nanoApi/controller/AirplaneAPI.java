package com.nanofly.nanoApi.controller;

import com.nanofly.nanoApi.model.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneAPI {
    Optional<Airplane> getAirplane(Long id);
    List<Airplane> getAll();
    Airplane create(Airplane airplane);
    Optional<Airplane> delete(Long id);
}
