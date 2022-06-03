package com.nanofly.nanoApi.service.impl;

import com.nanofly.nanoApi.model.Airport;
import com.nanofly.nanoApi.repository.AirportRepository;
import com.nanofly.nanoApi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    /**
     * Obtiene el aeropuerto segun el ID recibido como parametro.
     *
     * Get the airport by ID as parameter.
     *
     * @param id
     * @return Airport
     */
    @Override
    public Optional<Airport> getAirport(Long id) {
        return airportRepository.findById(id);
    }

    /**
     * Obtiene todos los vuelos que hay en la base de datos.
     *
     * Get all flight that have in database.
     *
     * @return List<Airport>
     */
    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    /**
     * Crea el aeropuerto que recibe como parametro.
     *
     * Creates the airport that receives as a parameter.
     *
     * @param airport
     * @return airport
     */
    @Override
    public Airport create(Airport airport) {
        return airportRepository.save(airport);
    }

    /**
     * Elimina el aeropuerto segun el ID recibido como parametro.
     *
     * Delete the airport by ID as parameter.
     *
     * @param id
     * @return airport
     */
    @Override
    public Optional<Airport> delete(Long id) {
        Optional<Airport> airportDelete=airportRepository.findById(id);
        airportRepository.deleteById(id);
        return airportDelete;
    }
}
