package org.example.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private double salary;
    private String location;
}
