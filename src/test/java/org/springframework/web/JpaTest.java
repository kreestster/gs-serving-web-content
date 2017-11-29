package org.springframework.web;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.entity.Employee;
import org.springframework.web.entity.EmployeeRepository;

@SpringBootTest
public class JpaTest {
	
	private static Logger log = Logger.getLogger(JpaTest.class);
	
	private Employee manager;
	
	private Employee s1;
	
	private Employee s2;

	@Autowired
	private EmployeeRepository repo;
	
	@Test
	public void test1() {
		repo.save(new Employee("Enzo", "Bellitto"));
		repo.save(new Employee("Christian", "Lombardi"));
		repo.save(new Employee("Antonio", "Mungari"));
		repo.save(new Employee("Saverio", "Argirò"));
		repo.save(new Employee("Giovanni", "Lombardi"));
	
		ArrayList<Employee> subs = new ArrayList<>();
		s1 = repo.getOne(1L);
		s2 = repo.getOne(2L);
		subs.add(s1);
		subs.add(s2);
		
		manager = repo.getOne(3L);
		manager.setSubEmployers(subs);
		repo.saveAndFlush(manager);
		
		if(repo.getSubEmployersById(manager.getId()) != null && repo.getSubEmployersById(manager.getId()).size()> 0)
			log.info("Manager has sub employers:  y");
		
		if(repo.getSubEmployersById(s1.getId()) != null && repo.getSubEmployersById(s1.getId()).size()> 0)
			log.info("s1 has sub employers: y");
		
		if(repo.getSubEmployersById(s2.getId()) != null && repo.getSubEmployersById(s2.getId()).size()> 0)
			log.info("s2 has sub employers: y");
		
		
		//fetch all customers
		log.info("customers found with findAll():");
		log.info("-------------------------------");
		for(Employee c:repo.findAll()){
			log.info(c.toString());
		}
		
		
		//fetch an individual customer by ID
		Employee c = repo.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(c.toString());
		log.info("");
	
		// fetch customers by last name
		log.info("Customer found with findByLastName('Lombardi'):");
		log.info("--------------------------------------------");
		for (Employee lombardi : repo.findByLastName("Lombardi")) {
			log.info(lombardi.toString());
		}
		log.info("");
		
	}
}
