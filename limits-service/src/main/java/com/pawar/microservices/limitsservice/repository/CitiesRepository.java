package com.pawar.microservices.limitsservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pawar.microservices.limitsservice.model.City;

@Repository
public interface CitiesRepository extends CrudRepository<City, Long>{

}
