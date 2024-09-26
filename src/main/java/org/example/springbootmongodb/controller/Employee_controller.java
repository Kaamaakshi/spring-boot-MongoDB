package org.example.springbootmongodb.controller;

import org.example.springbootmongodb.service.Employee_service;
import org.example.springbootmongodb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Employee_controller {
    @Autowired
    Employee_service employeeDao;

    //inserting data

    @PostMapping
    public String insert(@RequestBody Employee employeeDto) {
        return employeeDao.insert(employeeDto);
    }

    //fetching data by passing id

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id){
        return employeeDao.findById(id);
    }

    //fetching all data

    @GetMapping
    public List<Employee> findAll(){
        List<Employee> list=employeeDao.findAll();
        return list;
    }

    //deleting data by passing id

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
       return employeeDao.deleteById(id);
    }

    //deleting data by passing id

    @DeleteMapping
    public String deleteAll() {
        return employeeDao.deleteAll();
    }

    //updating data by passing id

    @PutMapping("/{id}")
    @ResponseBody
    public String update(@RequestBody Employee employeeDto, @PathVariable int id) {
        return employeeDao.update(employeeDto, id);
    }
}
