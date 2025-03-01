package com.bridgelabz.employeepayrollapp.dto;
import java.util.List;

import jakarta.validation.constraints.*;

public  class EmployeeDTO {
	@Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
    @NotEmpty(message="Employee name connot be null")
		   public String name;
	
   
   @Min(value=500,message="Min wage should be more than 500")
   public long salary;
   
   public EmployeeDTO(String name,long salary) {
	   this.name = name;
	   this.salary=salary;
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