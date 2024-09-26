package org.example.springbootmongodb.repository;

import org.example.springbootmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Employee_repository extends MongoRepository<Employee,Integer>{
}
