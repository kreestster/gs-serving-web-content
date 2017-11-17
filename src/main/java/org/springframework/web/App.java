package org.springframework.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.entity.Customer;
import org.springframework.web.entity.CustomerRepository;

@SpringBootApplication
public class App {
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String...strings){
		SpringApplication.run(App.class, strings);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repo){
		repo.save(new Customer("Enzo", "Bellitto"));
		repo.save(new Customer("Christian", "Lombardi"));
		repo.save(new Customer("Antonio", "Mungari"));
		repo.save(new Customer("Saverio", "Argirò"));
		repo.save(new Customer("Giovanni", "Lombardi"));
		
		
		//fetch all customers
		log.info("customers found with findAll():");
		log.info("-------------------------------");
		for(Customer c:repo.findAll()){
			log.info(c.toString());
		}
		
		
		//fetch an individual customer by ID
		Customer c = repo.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(c.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Lombardi'):");
		log.info("--------------------------------------------");
		for (Customer lombardi : repo.findByLastName("Lombardi")) {
			log.info(lombardi.toString());
		}
		log.info("");
		
		return null;
	}
}