package org.example.springbootmongodb.service;

import org.example.springbootmongodb.model.Employee;
import org.example.springbootmongodb.repository.Employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Employee_service {
    @Autowired
    Employee_repository employee_repository;

    //inserting data

    public String insert(Employee employee){
        employee_repository.save(employee);
        return "data inserted successfully";
    }

    //fetching data by passing id

    public Employee findById(int id){
        Optional<Employee> op =employee_repository.findById(id);
        if(op.isPresent())
        {
            return op.get();
        }else{
            return null;
        }
    }

    //fetching all data

    public List<Employee> findAll(){
       List<Employee> list= employee_repository.findAll();
       if(list.isEmpty()){
           return null;
       }else{
           return  list;
       }
    }

    //deleteing data by passing id

    public String deleteById(int id){
        Optional<Employee> op=employee_repository.findById(id);
        if(op.isPresent()){
            employee_repository.deleteById(id);
            return "data deleted";
        }else{
            return "data not found";
        }
    }

    //deleting all data

    public String deleteAll(){
        List<Employee> list=employee_repository.findAll();
        if(list.isEmpty()){
            return "data not found";
        }else{
            employee_repository.deleteAll();
            return " all data deleted";
        }
    }

    //updating data by passing id

    public String update(Employee employee, int id){
        Optional<Employee> op=employee_repository.findById(id);
        if(op.isPresent()){
            Employee emp=op.get();
             emp.setName(employee.getName());
             emp.setSalary(employee.getSalary());
            return "data updated";
        }else{

            return  "data not found with this id"+ "  "+id;
        }
    }
}
