package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

//Project Object Model file:POM file
@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args)  {
		SpringApplication.run(MycoolappApplication.class, args);

	}
}
