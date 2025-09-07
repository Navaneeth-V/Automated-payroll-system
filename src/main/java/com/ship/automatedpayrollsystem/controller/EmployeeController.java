package com.ship.automatedpayrollsystem.controller;

import com.ship.automatedpayrollsystem.model.Employee;
import com.ship.automatedpayrollsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from Employee service");
    }

    @GetMapping("/getAll")
    public Iterable<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
