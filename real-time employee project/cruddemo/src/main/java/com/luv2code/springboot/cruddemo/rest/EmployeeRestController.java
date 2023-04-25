package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
      employeeService=theemployeeService;
    }

    //expose: "/employees" and return a list of employee
    @GetMapping("/employees")
    public List<Employee>findAll(){
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);

        if ((theEmployee==null)){
            throw new RuntimeException("Employe Id not found" +employeeId);
        }else {
            return theEmployee;
        }
    }

    //add mapping for POST /employees - add new one

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //also just in case  they pass an id  in JSON ... set id to 0
        //this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee=employeeService.save(theEmployee);

        return dbEmployee;
    }

     //add mapping for PUT /employees - update existing employee

     @PutMapping("/employees")
     public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee =employeeService.save(theEmployee);

        return dbEmployee; //it has last updates the database
     }

     //add mapping for DELETE /employees - ByemployeeID
     @DeleteMapping("/employees/{employeeId}")
     public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee=employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee Id not Found" + employeeId);
        }
        employeeService.delete(employeeId);

        return "Deleted Employee ID: " +employeeId;
    }
}
