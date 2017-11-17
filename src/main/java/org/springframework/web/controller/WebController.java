package org.springframework.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.entity.Customer;
import org.springframework.web.entity.CustomerRepository;


@Controller
public class WebController {
	
	@Autowired
	CustomerRepository repo;
	
//	@RequestMapping("/greetings")
//	public String greetings(@RequestParam(value="name", required=false) String name, Model model){
//		model.addAttribute("name", name);
//		return "greetings";
//	}
	
	@RequestMapping("/findByLastname")
	@ResponseBody
	public List<Customer> findByLastname(@RequestParam(value="lastName", required=true) String lastName){
		return repo.findByLastName(lastName);
	}
}
