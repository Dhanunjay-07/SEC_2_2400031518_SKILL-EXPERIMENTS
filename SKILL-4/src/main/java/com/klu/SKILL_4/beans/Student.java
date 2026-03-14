package com.klu.SKILL_4.beans;

public class Student {
private int studentId;
private String name;
private String course;
private int year;

public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Student(int studentId, String name, String course, int year) {
	super();
	this.studentId = studentId;
	this.name = name;
	this.course = course;
	this.year = year;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [StudentId=" + studentId + ", name=" + name + ", Course=" + course + ", year=" + year + "]";
}

}
