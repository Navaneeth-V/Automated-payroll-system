package com.ship.automatedpayrollsystem.service;

import com.ship.automatedpayrollsystem.model.Employee;
import com.ship.automatedpayrollsystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employee.getId());

        if(optionalEmployee.isPresent()) {
            return this.employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Employee not found for id" + employee.getId());
        }
    }

    public void deleteEmployeeById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
