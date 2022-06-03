package com.nanofly.nanoApi.repository;

import com.nanofly.nanoApi.model.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends MongoRepository<Airplane, Long> {

}
