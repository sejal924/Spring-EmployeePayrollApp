package com.bridgelabz.employeepayrollapp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		 final Logger log = (Logger) LoggerFactory.getLogger(EmployeePayrollAppApplication.class);
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee Payroll App Started");
	}
	
}
