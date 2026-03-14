package com.klu.entity;


import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Employee {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String ename;
  private String email;
  
  public Employee() {
	// TODO Auto-generated constructor stub
}

  public Employee(int id, String ename, String email) {
	super();
	this.id = id;
	this.ename = ename;
	this.email = email;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getEname() {
	return ename;
  }

  public void setEname(String ename) {
	this.ename = ename;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  @Override
  public String toString() {
	return "Employee [id=" + id + ", ename=" + ename + ", email=" + email + "]";
  }
  
}