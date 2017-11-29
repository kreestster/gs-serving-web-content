package org.springframework.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.entity.Employee;
import org.springframework.web.entity.EmployeeRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class App {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	  
	public static void main(String...strings){
		//Configure using holidays-server.yml
		System.setProperty("spring.config.name", "holidays-server");
		SpringApplication.run(App.class, strings);
	}


	
	
}

//@Component
//class Demo implements CommandLineRunner{
//	
//	private static final Logger log = LoggerFactory.getLogger(Demo.class);
//
//	
//	EmployeeRepository repo;
//	
//	public void run(String...strings) throws Exception {
//	repo.save(new Employee("Enzo", "Bellitto"));
//	repo.save(new Employee("Christian", "Lombardi"));
//	repo.save(new Employee("Antonio", "Mungari"));
//	repo.save(new Employee("Saverio", "Argirò"));
//	repo.save(new Employee("Giovanni", "Lombardi"));
//
//	ArrayList<Employee> subs = new ArrayList<>();
//	Employee s1 = repo.getOne(1L);
//	Employee s2 = repo.getOne(2L);
//	subs.add(s1);
//	subs.add(s2);
//	
//	Employee manager = repo.getOne(3L);
//	manager.setSubEmployers(subs);
//	repo.saveAndFlush(manager);
//	
//	//
//	
//	if(repo.getSubEmployersById(manager.getId()) != null && repo.getSubEmployersById(manager.getId()).size()> 0)
//		log.info("Manager has sub employers:  y");
//	
//	if(repo.getSubEmployersById(s1.getId()) != null && repo.getSubEmployersById(s1.getId()).size()> 0)
//		log.info("s1 has sub employers: y");
//	
//	if(repo.getSubEmployersById(s2.getId()) != null && repo.getSubEmployersById(s2.getId()).size()> 0)
//		log.info("s2 has sub employers: y");
//	
//	
//	//fetch all customers
//	log.info("customers found with findAll():");
//	log.info("-------------------------------");
//	for(Employee c:repo.findAll()){
//		log.info(c.toString());
//	}
//	
//	
//	//fetch an individual customer by ID
//	Employee c = repo.findOne(1L);
//	log.info("Customer found with findOne(1L):");
//	log.info("--------------------------------");
//	log.info(c.toString());
//	log.info("");
//
//	// fetch customers by last name
//	log.info("Customer found with findByLastName('Lombardi'):");
//	log.info("--------------------------------------------");
//	for (Employee lombardi : repo.findByLastName("Lombardi")) {
//		log.info(lombardi.toString());
//	}
//	log.info("");
//	
//	}
//}