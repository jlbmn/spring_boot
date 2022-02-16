package fr.formation.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.dao.CustomerDao;
import fr.formation.inti.entity.Customer;
import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.CustomerService;

@Controller
public class IndexController {
	
	@Autowired
	CustomerDao customerDao ; 
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index(Model model) {
		return "hello";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String postForm(Model model, @RequestParam String name) {
		model.addAttribute("message", "Hello my dear "+name+ "!" );
		List<String> list = new ArrayList<String>();
		list.add("Johana");
		list.add("Anita");
		list.add("Fave");
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		Employee e1 = new Employee(1, "Prenom1", "Nom1");
		Employee e2 = new Employee(2, "Prenom2", "Nom2");
		Employee e3 = new Employee(3, "Prenom3", "Nom3");
		Employee e4 = new Employee(4, "Prenom4", "Nom4");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		model.addAttribute("listEmp", list);		
		return "index";
	}
	
	@RequestMapping(value = "/listCustomer", method = RequestMethod.GET)
	public String listCustomer(Model model) {
		List<Customer> list = customerService.findAll();
		model.addAttribute("listCustomer", list);
		return "index";
	}
	
	@RequestMapping(value = "/listByState", method = RequestMethod.POST)
	public String listCustomerByState(Model model, @RequestParam String state) {
		List<Customer> list = customerService.findByState(state);
		model.addAttribute("listByState", list);
		return "index";
	}
	
	@RequestMapping(value = "/listByFedId", method = RequestMethod.GET)
	public String listCustomerByFedId(Model model) {
		List<Customer> list = customerService.findByFedId();
		model.addAttribute("listByFedId", list);
		return "index";
	}
	
	@RequestMapping(value = "/listByAddress", method = RequestMethod.POST)
	public String listCustomerByAddress(Model model, @RequestParam String address) {
		List<Customer> list = customerService.findByAddress(address);
		model.addAttribute("listByAddress", list);
		return "index";
	}
	
	@RequestMapping(value = "/listByPostalCode", method = RequestMethod.POST)
	public String listCustomerByPostalCode(Model model, @RequestParam String code) {
		List<Customer> list = customerService.findByPostalCode(code);
		model.addAttribute("listByPostalCode", list);
		return "index";
	}
	
}
