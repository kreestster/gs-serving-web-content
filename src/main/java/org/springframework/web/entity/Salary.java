package org.springframework.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Salary {
	@Id
	@GeneratedValue
	private long salaryId;
	private long salary;
	private String description;
	
	protected Salary(){}
	
	public Salary(long salary, String desc){
		this.salary = salary;
		this.description = desc;
	}
	public long getSalaryId() {
		return salaryId;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
