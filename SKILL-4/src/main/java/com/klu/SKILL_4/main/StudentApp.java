package com.klu.SKILL_4.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.SKILL_4.beans.Student;
import com.klu.SKILL_4.config.AppConfig;

public class StudentApp {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
	Student st=context.getBean(Student.class);
	System.out.println(st);
}
}
