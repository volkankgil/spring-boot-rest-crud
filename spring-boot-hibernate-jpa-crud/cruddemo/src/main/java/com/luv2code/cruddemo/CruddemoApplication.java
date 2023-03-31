package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			//queryForSearchingLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Volkan", "Kebap", "volkankgil@gmail.com");

		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generated ID :" + tempStudent.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create multiple students

		System.out.println("Creating 3  new student object");
		Student tempStudent1 = new Student("Volkan", "Kebap", "volkankgil@gmail.com");
		Student tempStudent2 = new Student("Marin", "Kebap", "marinkgil@gmail.com");
		Student tempStudent3 = new Student("Tümay", "Kebap", "tümaykgil@gmail.com");

		//save the students objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object

		Student tempStudent = new Student("Berkan", "Keba", "berkankgil@gmail.com");

		//save the student
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println(myStudent.toString());
	}

	private void queryForStudent(StudentDAO studentDAO){

		//get database as a list
		List<Student>theStudents=studentDAO.findAll();

		//toString data's
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForSearchingLastName(StudentDAO studentDAO) {
		//get list of students
		List<Student> theStudents = studentDAO.findByLastName("keba");

		//display list of Students
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id:" +studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Asim");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student : " +myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("Deleting student id : " +studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int numRowsDeleted=studentDAO.deleteAllStudent();
		System.out.println("Deleted row Count : " + numRowsDeleted);
	}

}

	//	ALTER TABLE student_tracker.student AUTO_INCREMENT=3000  BU SORGUYU SQL YAZIP RUN YAPAR İSEK İD 3000'DEN BAŞLAYARAK ARTAR.
    //  ALTER TABLE student_tracker.student DATABASE 'İ SİLİYOR.
