package com.bridgelabz.employeepayrollapp.controller;

/*
Use Case : 5
This is Rest Controller file to ensure that data is transmitted in REST calls.
Ability for the Services Layer to store the Employee Payroll Data
In this use case the Services Layer will store this Data in a Memory as a List.
Database is not used.
*/

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

 @Autowired
 private EmployeeService employeeService;

 @GetMapping("")
 public List<Employee> getAllEmployeeDetails() {
     return employeeService.getAllEmployeeDetails();
 }
 @GetMapping("/get/{id}")
 public Optional<Employee> getSpecificEmployeeDetails(@PathVariable long id) {
	 
     Employee employee = employeeService.getEmployeeDetailsByID(id);
     if (employee != null) {
         return Optional.of(employee);
     } else {
         return Optional.empty();
     }
 }

 @PostMapping("/create")
 public String creatingEmployeeRecord(@Valid @RequestBody EmployeeDTO employeeDTO){
     Employee employee=employeeService.createEmployeeRecord(employeeDTO);
     return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
 }

 @PutMapping("/update/{id}")
 public String updatingEmployeeDetails(@Valid @PathVariable long id,@RequestBody EmployeeDTO employeeDTO) {
     Employee employee = employeeService.updateEmployeeRecord(id, employeeDTO);
     if (employee != null) {
         return "Updated employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
     } else {
         return "Employee record not found";
     }
 }

 @DeleteMapping("/delete/{id}")
 public String deletingEmployeeDetails(@PathVariable long id){
     return employeeService.deleteEmployeeRecordByID(id);
 }

}