package org.springframework.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.entity.Employee;
import org.springframework.web.entity.EmployeeRepository;

@RestController
public class WebController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	/**
	 * Spring Cloud DiscoveryClient abstraction to interrogate the registry for it’s own host and port.
	 * */
	@RequestMapping("/services-instances/{applicationName}")
	public List<ServiceInstance> getServiceInstancesByApplicationName(@PathVariable String applicationName){
		return this.discoveryClient.getInstances(applicationName);
		
	}
	
	@RequestMapping("/greetings")
	public String greetings(@RequestParam(value="name", required=false) String name, Model model){
		model.addAttribute("name", name);
		return "greetings";
	}
	
	@RequestMapping(value="/findByLastname", method=RequestMethod.GET)
	public List<Employee> findByLastname(@RequestParam(value="lastName", required=true) String lastName){
		return repo.findByLastName(lastName);
	}
	
	@RequestMapping(value="/saveSuca", method=RequestMethod.POST)
	public void saveUser(@RequestBody Employee emp){
		if(emp == null){
			emp = new Employee("John", "Lennon");
			
		}
		repo.saveAndFlush(emp);
	}
	
}
