package com.bridgelabz.employeepayrollapp.controller;
/*
Use Case : 4
This is Rest Controller file to ensure that data is transmitted in REST calls.
Note that Controller in UC4 was calling services layer to manage the Model.
Service Layer: creating the Model and returning the Model on the REST Calls(Controller).
Database is not used.
*/
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeePayrollService")
public class EmployeeRestController {

 @GetMapping("")
 public String getAllEmployeeDetails(){
     return "GET: getting all employee record";
 }

 @GetMapping("/get/{id}")
 public String getSpecificEmployeeDetails(@PathVariable long id){
     return "GET: getting employee record with id " + id ;
 }

 @PostMapping("/create")
 public String creatingEmployeeRecord(@RequestBody EmployeeDTO employeeDTO){
     Employee employee=new Employee();

     String name=employeeDTO.getName();
     double salary=employeeDTO.getSalary();

     employee.setName(name);
     employee.setSalary(salary);
     return "Created employee record\nname = " + employee.getName() + "\nsalary = " + employee.getSalary();
 }

 @PutMapping("/update")
 public String updatingEmployeeDetails(@RequestBody EmployeeDTO employeeDTO){
     Employee employee=new Employee();

     String name=employeeDTO.getName();
     double salary=employeeDTO.getSalary();

     employee.setName(name);
     employee.setSalary(salary);
     return "Updated employee record\nname = " +  employee.getName() + "\nsalary = " + employee.getSalary();
 }

 @DeleteMapping("/delete/{id}")
 public String deletingEmployeeDetails(@PathVariable long id){
     return "DELETE: deleted employee record with id " + id ;
 }

}