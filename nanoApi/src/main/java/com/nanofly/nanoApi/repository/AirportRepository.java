package com.nanofly.nanoApi.repository;

import com.nanofly.nanoApi.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends MongoRepository<Airport, Long> {

}
