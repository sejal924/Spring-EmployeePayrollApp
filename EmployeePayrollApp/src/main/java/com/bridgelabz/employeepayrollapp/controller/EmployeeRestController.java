package com.bridgelabz.employeepayrollapp.controller;

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
     return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary() + "\ngender = " + employee.getGender() + "\ndepartment = " + employee.getDepartment() + "\nstartDate = " + employee.getStartDate() + "\nnote = " + employee.getNote() + "\nprofilePic = " + employee.getProfilePic();
 }

 @PutMapping("/update/{id}")
 public String updatingEmployeeDetails(@Valid @PathVariable long id,@RequestBody EmployeeDTO employeeDTO) {
     Employee employee = employeeService.updateEmployeeRecord(id, employeeDTO);
     if (employee != null) {
         return "Updated employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary() + employee.getSalary() + "\ngender = " + employee.getGender() + "\ndepartment = " + employee.getDepartment() + "\nstartDate = " + employee.getStartDate() + "\nnote = " + employee.getNote() + "\nprofilePic = " + employee.getProfilePic();
     } else {
         return "Employee record not found";
     }
 }

 @DeleteMapping("/delete/{id}")
 public String deletingEmployeeDetails(@PathVariable long id){
     return employeeService.deleteEmployeeRecordByID(id);
 }

}