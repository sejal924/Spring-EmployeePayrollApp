package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeDetails(){
         return employeeRepository.findAll();
    }

    public Employee getEmployeeDetailsByID(long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow( ()->new EmployeePayrollException(id));
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }

    public Employee createEmployeeRecord(EmployeeDTO employeeDTO){
        Employee employee=new Employee(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeeDTO employeeDTO) {
            Employee employee = getEmployeeDetailsByID(id);
            employee.updateEmployeeData(employeeDTO);
            return employeeRepository.save(employee);
    }

    public String deleteEmployeeRecordByID(long id) {
        Employee employee = getEmployeeDetailsByID(id);
        if(employee!=null){
            employeeRepository.delete(employee);
            return "Employee data with id " + id + " is deleted";
        }
        return "Employee record not found";
    }

}