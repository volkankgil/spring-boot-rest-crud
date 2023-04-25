package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService{

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);  // burada baştaki employee geri dönus değeridir. accesiser başına yazmadık.

    void delete(int theId);

}
