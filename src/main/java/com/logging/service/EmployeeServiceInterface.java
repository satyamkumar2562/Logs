package com.logging.service;

import com.logging.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmpById( Long id);

    void deleteEmpById(Long empid);
}