package org.springframework.web.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
	List<Employee> findByLastName(String lastName);
	List<Employee> getSubEmployersById(Long id);
}
