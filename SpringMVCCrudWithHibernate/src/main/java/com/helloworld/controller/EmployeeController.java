package com.helloworld.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.helloworld.domain.Employee;
import com.helloworld.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@RequestMapping(value = "/employeePortal", method = RequestMethod.GET)
	public ModelAndView showEmployeePortal(ModelAndView modelAndView) {
		Employee employee = new Employee();
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("listEmployee", employeeService.getAllEmployeeDetails());	
		modelAndView.setViewName("employeeportal");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView  saveEmployee(
			HttpServletRequest request,
			@ModelAttribute("employee")
			Employee employee) {		
		System.out.println("Employee Object ::"  + employee);
		Boolean isEmployeeDetailsInserted = employeeService.insertEmployeeDetails(employee);

		if(isEmployeeDetailsInserted) {
			System.out.println("Inserted Successfully!!!");
		} else {
			System.out.println("Not Inserted!!!");
		}
		return   new ModelAndView( "redirect:/employeePortal");
	}	   
	
	@RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@PathVariable("id") Integer employeeId) {
		//int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployeeDetail(employeeId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeEdit", employee);
		System.out.println("Going to edit -- "+employeeId);
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getAddress());
		System.out.println(employee.getTelephone());
		
		modelAndView.setViewName("employeePortal");
		//return modelAndView;
		return null;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView  updateEmployee(
			HttpServletRequest request,
			@ModelAttribute("employee")
			Employee employee) {		
		System.out.println("Employee Object ::"  + employee);
		Boolean isEmployeeDetailsInserted = employeeService.updateEmployeeDetails(employee);

		if(isEmployeeDetailsInserted) {
			System.out.println("Record updated  Successfully!!!");
		} else {
			System.out.println("Not Inserted!!!");
		}
		return   new ModelAndView( "redirect:/employeePortal");
	}	
	
}

