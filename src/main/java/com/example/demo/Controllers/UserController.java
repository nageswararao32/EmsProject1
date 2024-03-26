package com.example.demo.Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entites.Employee;
import com.example.demo.Services.EmployeeService;


@Controller
@CrossOrigin("*")
public class UserController {

	@Autowired
	
    EmployeeService service;

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee emp) {
    	System.out.println(emp);
        service.addEmployee(emp);
        return "addded";
    }
    
    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("employees", employees);
        return "getall";
    }
    
    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }
    
    @GetMapping("/view/{id}")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Optional<Employee> emp = service.findEmployeeById(id);
        if (emp.isPresent()) {

            model.addAttribute("emp", emp);
            
            return "empDetails";
        } else {
            return "Employee not found";
        }
    }
    
    @GetMapping("/nextPage/{id}")
    public String nextPage(@PathVariable Long id, Model model) {
        Optional<Employee> employ = service.findEmployeeById(id);
        if (employ.isPresent()) {
            model.addAttribute("employ", employ);
            return "nextPage";
        } else {
            return "Employee not found";
        }
    }

    
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employeeDetails, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = service.findEmployeeById(id);
        System.out.println(employeeDetails);
        if (employee.isPresent()) {
            service.updateEmployee(id, employeeDetails);
            redirectAttributes.addFlashAttribute("message", "Employee Updated Successfully!");
            return "redirect:/update-success";
        } else {
            redirectAttributes.addFlashAttribute("error", "Employee not found");
            return "redirect:/update-error";
        }
    }


    
    
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = service.findEmployeeById(id);
        if (employee.isPresent()) {
            service.deleteEmployee(id);
                return ResponseEntity.ok("Employee deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }
}
