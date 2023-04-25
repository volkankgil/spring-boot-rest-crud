package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entityManager

    private EntityManager entityManager;

    //set up constructor injection
    //
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;  //entity manager started automaticly by springframework
    }

    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

        //execute query and get result list
        List<Employee>employees=theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee employee=entityManager.find(Employee.class,theId);

        //return employee
        return employee;
    }
    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee dbEmployee=entityManager.merge(theEmployee); //id sıfır ise save yapar sıfır değil ise update yapacaktır.

        //return db Employee
        return dbEmployee;
    }

    @Override
    public void delete(int theId) {

        //find employee by ID
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //remove employee
        entityManager.remove(theEmployee);
    }
}
