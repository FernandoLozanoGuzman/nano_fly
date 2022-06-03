package com.nanofly.nanoApi.repository;

import com.nanofly.nanoApi.model.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends MongoRepository<Airline, Long> {

}
