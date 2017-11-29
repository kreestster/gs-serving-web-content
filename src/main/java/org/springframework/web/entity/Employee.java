package org.springframework.web.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Calendar hireDate;
	
	@OneToOne
	private Salary salary;
	private long totalDaysOff;
	private long leftDaysOff;
	private long totalTimeOff;
	private long leftTimeOff;
	
	@OneToMany
	private List<Job> jobs;
	@OneToMany
	private List<Employee> subEmployers;
	
	protected Employee(){}
	
	
	
	public Employee(String firstName, String lastName, String email, String phoneNumber, Calendar hireDate,
			Salary salary, long totalDaysOff, long leftDaysOff, long totalTimeOff, long leftTimeOff, List<Job> jobs,
			List<Employee> subEmployers) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.totalDaysOff = totalDaysOff;
		this.leftDaysOff = leftDaysOff;
		this.totalTimeOff = totalTimeOff;
		this.leftTimeOff = leftTimeOff;
		this.jobs = jobs;
		this.subEmployers = subEmployers;
	}



	public Employee(String name, String lastName){
		this.firstName = name;
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		return String.format("Customer[id=%d, firstname=%s, lastname=%s", this.id, this.firstName, this.lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalaryId(Salary salary) {
		this.salary = salary;
	}

	public long getTotalDaysOff() {
		return totalDaysOff;
	}

	public void setTotalDaysOff(long totalDaysOff) {
		this.totalDaysOff = totalDaysOff;
	}

	public long getLeftDaysOff() {
		return leftDaysOff;
	}

	public void setLeftDaysOff(long leftDaysOff) {
		this.leftDaysOff = leftDaysOff;
	}

	public long getTotalTimeOff() {
		return totalTimeOff;
	}

	public void setTotalTimeOff(long totalTimeOff) {
		this.totalTimeOff = totalTimeOff;
	}

	public long getLeftTimeOff() {
		return leftTimeOff;
	}

	public void setLeftTimeOff(long leftTimeOff) {
		this.leftTimeOff = leftTimeOff;
	}



	public List<Employee> getSubEmployers() {
		return subEmployers;
	}



	public void setSubEmployers(List<Employee> subEmployers) {
		this.subEmployers = subEmployers;
	}
}
