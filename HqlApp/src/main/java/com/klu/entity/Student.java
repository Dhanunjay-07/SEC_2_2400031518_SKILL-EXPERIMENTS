package com.klu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stud")
public class Student {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String name;
	private String course;
	private double fee;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, double fee,String course) {
		super();
		this.name = name;
		this.course = course;
		this.fee=fee;
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
	
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + "]";
	}
	
	
}
