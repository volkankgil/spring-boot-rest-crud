package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

@Entity //mapping to table
@Table(name="student") //database deki table'ın ismi
public class Student {

    //define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //İD PRİMARY KEY OLDUĞUNDAN vERİ EKLENDİĞİNDE OTOMATİK ARTIŞ SAĞLAYACAK
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String eMail;

    //define constructors

    public Student(){

    }

    public Student(String firstName,String lastName,String eMail){
        this.firstName=firstName;
        this.lastName=lastName;
        this.eMail=eMail;
    }

    //define getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    //define toString() method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

    //DAO = DATA ACCESS OBJECT / STUDENT İS DAO
}
