package com.logging.service.impl;

import com.logging.entity.Employee;
import com.logging.repository.EmployeeRepository;
import com.logging.service.EmployeeServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {
   Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public Employee addEmployee(Employee employee) {
            logger.info("Adding employee: {}", employee);
            try {
                Employee savedEmployee = employeeRepository.save(employee);
                logger.info("Employee added successfully: {}", savedEmployee);
                return savedEmployee;
            } catch (Exception e) {
                logger.error("Error adding employee: ", e);
                throw new RuntimeException("Error adding employee", e);
            }
        }

        @Override
        public List<Employee> getAllEmployees() {
            logger.info("Fetching all employees");
            try {
                List<Employee> employees = employeeRepository.findAll();
                logger.info("Fetched all employees successfully");
                return employees;
            } catch (Exception e) {
                logger.error("Error fetching all employees: ", e);
                throw new RuntimeException("Error fetching all employees", e);
            }
        }

        @Override
        public Employee getEmpById(Long id) {
            logger.info("Fetching employee by ID: {}", id);
            try {
                Optional<Employee> employeeOptional  = employeeRepository.findById(id);
                if (employeeOptional.isPresent()) {
                    Employee employee = employeeOptional.get();
                    logger.info("Employee found: {}", employee);
                    return employee;
                } else {
                    logger.warn("Employee not found with ID: {}", id);
                    throw new RuntimeException("Employee not found");
                }
            } catch (Exception e) {
                logger.error("Error fetching employee by ID: ", e);
                throw new RuntimeException("Error fetching employee by ID", e);
            }
        }

        @Override
        public void deleteEmpById(Long empid) {
            logger.info("Deleting employee by ID: {}", empid);
            try {
                employeeRepository.deleteById(empid);
                logger.info("Employee deleted successfully");
            } catch (Exception e) {
                logger.error("Error deleting employee by ID: ", e);
                throw new RuntimeException("Error deleting employee by ID", e);
            }
        }
    }


