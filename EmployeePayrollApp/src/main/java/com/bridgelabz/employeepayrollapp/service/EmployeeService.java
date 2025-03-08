package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.time.LocalDate;
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
    	return employees.stream().filter(empData->empData.getId()==id).findFirst().orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
      
    }

    public Employee createEmployeeRecord(EmployeeDTO employeeDTO){
        Employee employee=new Employee();

        String name=employeeDTO.getName();
        double salary=employeeDTO.getSalary();
        String gender=employeeDTO.getGender();
        String profilePic=employeeDTO.getProfilePic();
        String note = employeeDTO.getNote();
        LocalDate startDate=employeeDTO.getStartDate();
        List<String> department=employeeDTO.getDepartment();

        employee.setName(name);
        employee.setSalary(salary);
        employee.setGender(gender);
        employee.setProfilePic(profilePic);
        employee.setNote(note);
        employee.setStartDate(startDate);
        employee.setDepartment(department);

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
            String gender=employeeDTO.getGender();
            LocalDate startDate=employeeDTO.getStartDate();
            String note= employeeDTO.getNote();
            String profilePic= employeeDTO.getProfilePic();
            List<String>department=employeeDTO.getDepartment();

            if (!name.isEmpty()) {
                employee.setName(name);
            }
            if (salary > 0) {
                employee.setSalary(salary);
            }
            if(!gender.isEmpty()) {
            	employee.setGender(gender);
            }
            /*if(!startDate.isEmpty()) {
            	employee.setStartDate(startDate);
            }*/
            	employee.setStartDate(startDate);
  
            if(!profilePic.isEmpty()){
            	employee.setProfilePic(profilePic);
            }
            if(!note.isEmpty()) {
            	employee.setNote(note);
            }
            if(!department.isEmpty()) {
            	employee.setDepartment(department);
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
