package com.bridgelabz.employeepayrollapp.dto;
import lombok.Data;

public @Data class EmployeeDTO {
    private String name;
    private double salary;
    
    public EmployeeDTO(String name,double salary) {
    	this.name = name;
    	this.salary = salary;
    }
}