package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable String id) throws StudentNotFoundException {

		int studentId;

		try {
			studentId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Student ID must be a number");
		}

		return studentService.getStudentById(studentId);
	}
}
