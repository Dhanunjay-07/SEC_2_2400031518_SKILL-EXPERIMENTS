package com.klu.service;

import org.springframework.stereotype.Service;

import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;

@Service
public class StudentService {

	public Student getStudentById(int id) throws StudentNotFoundException {

		if (id == 1) {
			return new Student(1, "Dhanu", "CSE");
		}

		throw new StudentNotFoundException("Student with ID " + id + " not found");
	}
}
