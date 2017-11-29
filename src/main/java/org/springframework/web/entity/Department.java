/**
 * 
 */
package org.springframework.web.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author lombardichrist
 *
 */
public class Department {
	
	@Id
	@GeneratedValue
	private long id;
	private String department;
	@OneToOne
	private Location location;
	@OneToMany
	private List<Employee> employees;
	
	protected Department(){}
	
	public Department(long id, String department, Location location, List<Employee> employees) {
		super();
		this.id = id;
		this.department = department;
		this.location = location;
		this.employees = employees;
	}
	public long getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
