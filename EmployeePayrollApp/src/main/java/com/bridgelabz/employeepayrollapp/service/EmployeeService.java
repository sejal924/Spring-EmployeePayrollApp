package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
   private List<Employee> employees ;
   
   public EmployeeService() {
	   employees = new ArrayList<>();
   }
   
    public List<Employee> getAllEmployeeDetails(){
         return employees;
    }

    public Employee getEmployeeDetailsByID(long id) {
        return employees.get(((int)id)-1);
    }

    public Employee createEmployeeRecord(EmployeeDTO employeeDTO){
        Employee employee=new Employee();

        String name=employeeDTO.getName();
        double salary=employeeDTO.getSalary();

        employee.setName(name);
        employee.setSalary(salary);

        employees.add(employee);
        return employee;
    }

    public Employee updateEmployeeRecord(long id,EmployeeDTO employeeDTO) {
            Employee employee = getEmployeeDetailsByID(id);
            if(employee==null){
                return null;
            }
            String name = employeeDTO.getName();
            double salary = employeeDTO.getSalary();

            if (!name.isEmpty()) {
                employee.setName(name);
            }
            if (salary > 0) {
                employee.setSalary(salary);
            }
            return employee;
    }

    public String deleteEmployeeRecordByID(long id) {
        Employee employee = getEmployeeDetailsByID(id);
        if (employee == null) {
            return "Employee record not found";
        }
        else{
            for(int i=0;i<employees.size();i++){
                if(employees.get(i)==employee){
                    employees.remove(i);
                    return "Deleted Employee record with id " + id;
                }
            }
        }
        return "Employee record not found";
    }

}