package com.thomas.pma;

import com.thomas.pma.entities.Employee;
import com.thomas.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thomas.pma.dao.EmployeeRepository;
import com.thomas.pma.dao.ProjectRepository;
import com.thomas.pma.springExample.Car;
import com.thomas.pma.springExample.Doors;
import com.thomas.pma.springExample.Engine;
import com.thomas.pma.springExample.Tires;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages= {"com.thomas.pma", "com.thomas.utils"})
public class ProjectManagementApplication {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	
	




}
