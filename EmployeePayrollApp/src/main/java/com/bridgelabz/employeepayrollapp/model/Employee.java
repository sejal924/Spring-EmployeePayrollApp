package com.bridgelabz.employeepayrollapp.model;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="employee_payroll")
public @Data class Employee {

    private static long idcounter=1;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="name")
    private String name;
    private double salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    
    @ElementCollection
    @CollectionTable(name="department",joinColumns= @JoinColumn(name="id"))
    @Column(name="department")
    public List<String>department;
    
    public Employee() {
    	id = idcounter;
    	idcounter++;
    }
    
    
    public static long getIdcounter() {
		return idcounter;
	}


    public String getGender() {
    	return gender;
    }
    public LocalDate getStartDate() {
    	return startDate;
    }

    public String getNote() {
    	return note;
    }

    public String getProfilePic() {
    	return profilePic;
    }

    public List<String> getDepartment() {
    	return department;
    }
	public static void setIdcounter(long idcounter) {
		Employee.idcounter = idcounter;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}


	public void setDepartment(List<String> department) {
		this.department = department;
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
	 public Employee(EmployeeDTO employeeDTO){
	       this.name=employeeDTO.getName();
	       this.salary=employeeDTO.getSalary();
	       this.gender=employeeDTO.getGender();
	       this.startDate=employeeDTO.getStartDate();
	       this.note=employeeDTO.getNote();
	       this.profilePic=employeeDTO.getProfilePic();
	       this.department=employeeDTO.getDepartment();
	    }
	
}