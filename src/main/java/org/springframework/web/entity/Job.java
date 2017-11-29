package org.springframework.web.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Job {
	
	@Id
	private String jobTitle;
	private long minTimeDue;
	private long totalDue;
	@ManyToMany
	private List<Task> tasks;
	
	protected Job(){}
	
	public Job(String jobTitle, long minTimeDue, long totalDue, List<Task> tasks) {
		super();
		this.jobTitle = jobTitle;
		this.minTimeDue = minTimeDue;
		this.totalDue = totalDue;
		this.tasks = tasks;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public long getMinTimeDue() {
		return minTimeDue;
	}
	public void setMinTimeDue(long minTimeDue) {
		this.minTimeDue = minTimeDue;
	}
	public long getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(long totalDue) {
		this.totalDue = totalDue;
	}
	
	
	

}
