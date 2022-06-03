package com.nanofly.nanoApi.service.impl;

import com.nanofly.nanoApi.model.Airline;
import com.nanofly.nanoApi.repository.AirlineRepository;
import com.nanofly.nanoApi.repository.FlightRepository;
import com.nanofly.nanoApi.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    /**
     * Obtiene la aerolinea segun el ID recibido como parametro.
     *
     * Get the airline by ID as parameter.
     *
     * @param id
     * @return Airline
     */
    @Override
    public Optional<Airline> getAirline(Long id) {
        return airlineRepository.findById(id);
    }

    /**
     * Obtiene todos las aerolineas que hay en la base de datos.
     *
     * Get all airline that have in database.
     *
     * @return List<Airline>
     */
    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    /**
     * Crea la aerolinea que recibe como parametro.
     *
     * Creates the airline that receives as a parameter.
     *
     * @param airline
     * @return Airline
     */
    @Override
    public Airline create(Airline airline) {
        return airlineRepository.save(airline);
    }

    /**
     * Elimina la aerolinea segun el ID recibido como parametro.
     *
     * Delete the airline by ID as parameter.
     *
     * @param id
     * @return airline
     */
    @Override
    public Optional<Airline> delete(Long id) {
        Optional<Airline> airlineDeleted=airlineRepository.findById(id);
        airlineRepository.deleteById(id);
        return airlineDeleted;
    }
}
