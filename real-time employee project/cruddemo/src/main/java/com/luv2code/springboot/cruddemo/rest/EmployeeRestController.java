package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty: inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
      employeeService=theemployeeService;
    }

    //expose: "/employees" and return a list of employee
    @GetMapping("/employees")
    public List<Employee>findAll(){
        return employeeService.findAll();
    }
}
