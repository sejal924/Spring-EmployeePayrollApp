package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employee {

    private static long idcounter=1;
    private long id;
    private String name;
    private double salary;
    
    public Employee() {
    	id = idcounter;
    	idcounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

	public long getId() {
		
		return id;
	}

	
}