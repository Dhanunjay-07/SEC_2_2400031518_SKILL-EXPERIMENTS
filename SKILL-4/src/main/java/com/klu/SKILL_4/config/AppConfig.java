package com.klu.SKILL_4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.SKILL_4.beans.Student;

@Configuration
public class AppConfig {
	 @Bean
	    public Student student() {
	        return new Student(2, "Dhanu", "FSAD", 2026);
	    }
}
