package com.bridgelabz.employeepayrollapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

public @Data class Employee {

    private static long idcounter=1;
    private long id;
    private String name;
    private double salary;
    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
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
    public String getStartDate() {
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


	public void setStartDate(String startDate) {
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

	
}