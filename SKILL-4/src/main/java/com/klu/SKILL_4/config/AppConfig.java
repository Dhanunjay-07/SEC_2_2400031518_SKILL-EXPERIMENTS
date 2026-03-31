package com.klu.SKILL_4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.SKILL_4.beans.Student;

@Configuration
public class AppConfig {
	@Bean
	public Student student() {
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setName("Dhanu");
		s1.setCourse("FSAD");
		s1.setYear(2026);
		return s1;
	}
}
