package com.nanofly.nanoApi.service.impl;

import com.nanofly.nanoApi.model.Flight;
import com.nanofly.nanoApi.repository.FlightRepository;
import com.nanofly.nanoApi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Obtiene el vuelo segun el ID recibido como parametro.
     *
     * Get the flight by ID as parameter.
     *
     * @param id
     * @return flight
     */
    @Override
    public Optional<Flight> getFlight(Long id) {
        return flightRepository.findById(id);
    }

    /**
     * Obtiene todos los vuelos que hay en la base de datos.
     *
     * Get all flight that have in database.
     *
     * @return List<Flight>
     */
    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    /**
     * Crea el vuelo que recibe como parametro.
     *
     * Creates the flight that receives as a parameter.
     *
     * @param flight
     * @return flight
     */
    @Override
    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    /**
     * Elimina el vuelo segun el ID recibido como parametro.
     *
     * Delete the flight by ID as parameter.
     *
     * @param id
     * @return flight
     */
    @Override
    public Optional<Flight> delete(Long id) {
        Optional<Flight> flightDeleted=flightRepository.findById(id);
        flightRepository.deleteById(id);
        return flightDeleted;
    }

    /**
     * Obtiene todos los vuelos que hay en la base de datos y devuelve
     * solo los que coincida con los parametros de busqueda.
     *
     * Gets all the flights in the database and returns
     * only those that match the search parameters.
     *
     * @param airportOrigin
     * @param airportDestine
     * @return List<Flight>
     */
    @Override
    public List<Flight> searchByAirports(String airportOrigin, String airportDestine) {
        List<Flight> airports=new ArrayList<Flight>();
        List<Flight> allFlight=new ArrayList<Flight>();
        allFlight=flightRepository.findAll();
        for(int i=0;i< allFlight.size();i++) {
            if (allFlight.get(i).getAirportOrigin() != null || allFlight.get(i).getAirportDestine() != null) {
                if (allFlight.get(i).getAirportOrigin().getCity() != null || allFlight.get(i).getAirportDestine().getCity() != null) {
                    if (allFlight.get(i).getAirportOrigin().getCity().equalsIgnoreCase(airportOrigin) && allFlight.get(i).getAirportDestine().getCity().equalsIgnoreCase(airportDestine))
                        airports.add(allFlight.get(i));
                }
            }
        }
        return airports;
    }
    /**
     * Obtiene todos los vuelos que hay en la base de datos y devuelve
     * solo los que aterricen en el aeropuerto de destino y sean diferentes
     * al aeropuerto de salida introducido como parametro.
     *
     * Gets all the flights in the database and returns
     * only those that land at the destination airport and
     * are different from the departure airport entered as a parameter.
     *
     * @param airportOrigin
     * @param airportDestine
     * @return List<Flight>
     */
    @Override
    public List<Flight> searchByAirport(String airportOrigin, String airportDestine) {
        List<Flight> airports=new ArrayList<Flight>();
        List<Flight> allFlight=new ArrayList<Flight>();
        allFlight=flightRepository.findAll();
        for(int i=0;i< allFlight.size();i++) {
            if (allFlight.get(i).getAirportOrigin() != null || allFlight.get(i).getAirportDestine() != null) {
                if (allFlight.get(i).getAirportOrigin().getCity() != null || allFlight.get(i).getAirportDestine().getCity() != null) {
                    if (!allFlight.get(i).getAirportOrigin().getCity().equalsIgnoreCase(airportOrigin) && allFlight.get(i).getAirportDestine().getCity().equalsIgnoreCase(airportDestine))
                        airports.add(allFlight.get(i));
                }
            }
        }
        return airports;
    }

}
