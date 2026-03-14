package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.beans.Certification;
import com.klu.beans.Student;

@Configuration
public class AppConfig {
@Bean

public Student getStudent() {
	Student s=new Student();
	s.setId(1);
	s.setName("Dhanu");
	s.setGender("Male");
	return s;
	}
@Bean
public Certification getCertification() {
	Certification c=new Certification();
	c.setId(1);
	c.setName("Microsft");
	c.setDateofcompletion(2026);
	return c;
}
}
