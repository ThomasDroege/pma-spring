package com.thomas.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.thomas.pma.dto.EmployeeProject;
import com.thomas.pma.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	
	@Override
	public List<Employee> findAll();
	
	
	@Query(nativeQuery=true, value="SELECT e.firstname as firstName, e.lastname as lastName, COUNT(pe.employee_id) as projectCount " + 
			"FROM employee e left join project_employee pe ON pe.employee_id=e.employee_id " + 
			"GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
	
	public Employee findByEmail(String value);
	
	
	//another method for e.g. validation rules in UniqueValidator class
	public Employee findEmployeeByEmployeeId(long id);


}

