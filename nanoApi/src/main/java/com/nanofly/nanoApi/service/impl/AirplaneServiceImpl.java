package com.nanofly.nanoApi.service.impl;

import com.nanofly.nanoApi.model.Airplane;
import com.nanofly.nanoApi.repository.AirplaneRepository;
import com.nanofly.nanoApi.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    /**
     * Obtiene el avion segun el ID recibido como parametro.
     *
     * Get the airplane by ID as parameter.
     *
     * @param id
     * @return Airplane
     */
    @Override
    public Optional<Airplane> getAirplane(Long id) {
        return airplaneRepository.findById(id);
    }

    /**
     * Obtiene todos los aviones que hay en la base de datos.
     *
     * Get all airplane that have in database.
     *
     * @return List<Airplane>
     */
    @Override
    public List<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    /**
     * Crea el avion que recibe como parametro.
     *
     * Creates the airplane that receives as a parameter.
     *
     * @param airplane
     * @return airplane
     */
    @Override
    public Airplane create(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    /**
     * Elimina el avion segun el ID recibido como parametro.
     *
     * Delete the airplane by ID as parameter.
     *
     * @param id
     * @return airplane
     */
    @Override
    public Optional<Airplane> delete(Long id) {
        Optional<Airplane> airplaneDeleted=airplaneRepository.findById(id);
        airplaneRepository.deleteById(id);
        return airplaneDeleted;
    }
}
