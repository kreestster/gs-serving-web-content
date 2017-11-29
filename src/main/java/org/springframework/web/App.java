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

