package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents = new ArrayList<>();

    //define @PostConstruct to load the student data ... only once!!!

    @PostConstruct
    public void loadData() {

        theStudents.add(new Student("Volkan", "Kebap"));
        theStudents.add(new Student("Marin", "volkan "));
        theStudents.add(new Student("Tum", "VOLK"));
    }

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint or "/students/{studentId}" -return student at index

    @GetMapping("/students/{studentId}") // curly braces show actual path variable
    public Student getStudent(@PathVariable int studentId) {

        //CHECK THE STUDENTıd againist list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student Id not found : " + studentId);
        }
        return theStudents.get(studentId);
    }
}
//POJO=Plain old java objects ------ jackson pojo ve json arasında dönüşümü sağlıyor
