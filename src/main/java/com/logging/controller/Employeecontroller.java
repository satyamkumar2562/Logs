package com.logging.controller;

import com.logging.entity.Employee;
import com.logging.service.EmployeeServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class Employeecontroller {
    Logger logger= LoggerFactory.getLogger(Employeecontroller.class);
    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/save")
    public ResponseEntity<?>addEmployee(@RequestBody Employee employee){
        Employee employeesaved = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<>(employeesaved, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?>getAllEmployees(){
        logger.trace("starting method with trace log level");
        logger.info("starting method with Info log level");
        List<Employee> allEmployees = employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<>(allEmployees,HttpStatus.OK);

    }
    @GetMapping("/emp/{empid}")
    public ResponseEntity<?>getEmpById(@PathVariable("empid") Long empid){
        Employee empById = employeeServiceInterface.getEmpById(empid);
        return new ResponseEntity<>(empById,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<?> deleteEmpById(@PathVariable("empid") Long empid){
        employeeServiceInterface.deleteEmpById(empid);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
