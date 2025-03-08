package com.bridgelabz.employeepayrollapp.dto;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.*;
import lombok.ToString;

public @ToString class EmployeeDTO {
	@Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
    @NotEmpty(message="Employee name Invalid")
		   public String name;
	
   
   @Min(value=500,message="Min wage should be more than 500")
   public long salary;
   
   @Pattern(regexp="male|female",message="Gender needs to be male or female")
   public String gender;
   
   @JsonFormat(pattern="dd MMM yyyy")
   @NotNull(message="startDate should not be empty")
   @PastOrPresent(message="startDate should be past or todays date")
   public LocalDate startDate;
   
   @NotBlank(message = "Note cannot be empty")
   public String note;
   
   @NotBlank(message="profilePic cannot be empty")
   public String profilePic;
   
   @NotNull(message="department should not be empty")
   public List<String>department;
   
   public EmployeeDTO(String name,long salary,String gender,LocalDate startDate, String note,String profilePic, List<String>department) {
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