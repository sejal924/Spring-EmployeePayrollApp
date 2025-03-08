package com.bridgelabz.employeepayrollapp.exception;

public class EmployeePayrollException extends RuntimeException{

    public EmployeePayrollException(long id){
        super("Employee with ID " + id + " not found.");
    }
}