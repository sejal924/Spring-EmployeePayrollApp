package com.bridgelabz.employeepayrollapp.dto;
import java.util.List;

import jakarta.validation.constraints.*;
import lombok.ToString;

public @ToString class EmployeeDTO {
	@Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
    @NotEmpty(message="Employee name connot be null")
		   public String name;
	
   
   @Min(value=500,message="Min wage should be more than 500")
   public long salary;
   
   public String gender;
   public String startDate;
   public String note;
   public String profilePic;
   public List<String>department;
   
   public EmployeeDTO(String name,long salary,String gender,String startDate, String note,String profilePic, List<String>department) {
	   this.name = name;
	   this.salary=salary;
	   this.gender=gender;
	   this.startDate=startDate;
	   this.note=note;
	   this.profilePic=profilePic;
	   this.department=department;
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

public void setName(String name) {
	this.name = name;
}
public void setSalary(long salary) {
	this.salary = salary;
}
public String getName() {
	   return name;
   }
   public long getSalary() {
	   return salary;
   }
   @Override
   public String toString() {
	   return "name=" + name+ ":salary="+salary;
   }
   
}