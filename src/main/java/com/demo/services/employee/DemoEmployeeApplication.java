package com.demo.services.employee;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.services.employee.model.Employee;

@RestController
@SpringBootApplication
public class DemoEmployeeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoEmployeeApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoEmployeeApplication.class, args);
    }
  
   
    
    @RequestMapping("/api")
    public String getDefault() {
    	return "Welcome to Atomic API";
    }
 
    @RequestMapping(value = "/member", method = RequestMethod.GET)
	public List<Employee> getAllRecords() {
    	LOGGER.info("Entering...");
		List<Employee> empList=new ArrayList<Employee>();
		empList.add(new Employee("1","Sri"));
		empList.add(new Employee("2","Raj"));
		empList.add(new Employee("3","Sheldon"));
		empList.add(new Employee("4","Penny"));
		LOGGER.info("empList is:" + empList);
    	LOGGER.info("Leaving.");
		return empList;
	}
    
    @RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
   	public Employee getEmployeeById(@PathVariable String id) {
       return new Employee(id, "new emp");
   	}
    
    @RequestMapping(value = "/member/one", method = RequestMethod.GET)
   	public Employee getEmployee() {
    	LOGGER.info("Entering...");
    	Employee emp= new Employee("4","Norma");
    	LOGGER.info("emp is:" + emp);
    	LOGGER.info("Leaving.");
    	return emp;
   	}
    
    @RequestMapping(value = "/member/desc", method = RequestMethod.GET)
   	public String getEmployeeDesc() {
    	LOGGER.info("Entering...");
   		Employee emp= new Employee("4","Norma");
   		LOGGER.info("emp is:" + emp);
   		LOGGER.info("Leaving.");
   		return emp.getDesc();
   	}
    @RequestMapping(value = "/member", method = RequestMethod.POST)
   	public void postEmployee(@RequestBody Employee employee) {
    	LOGGER.info("Entering...");
    	LOGGER.info("Received:" + employee);
    	
    }
}
