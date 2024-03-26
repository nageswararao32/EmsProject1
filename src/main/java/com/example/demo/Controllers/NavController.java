package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/addEmployee")
	public String addEmployee() {
		return "addEmployee";
	}
	
	@GetMapping("/index")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/addded")
	public String homePae() {
		return "addded";
	}
	
	@GetMapping("/view/index")
	public String HomePage() {
		return "index";
	}
	
	@GetMapping("/view/addEmployee")
	public String AddEmployee() {
		return "addEmployee";
	}
	
	@GetMapping("/view/list")
	public String list() {
		return "getall";
	}
	
	@GetMapping("/update-success")
	public String upd() {
		return "update-success";
	}
	
	@GetMapping("/update-error")
	public String lis() {
		return "update-error";
	}
	
	@GetMapping("/nextPage/addEmployee")
	public String next() {
		return "addEmployee";
	}

}
