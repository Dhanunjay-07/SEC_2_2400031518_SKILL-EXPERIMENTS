package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
private int id;
private String name;
private String gender;
private Certification certificate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Certification getCertificate() {
	return certificate;
}
@Autowired
public void setCertificate(Certification certificate) {
	this.certificate = certificate;
}
public void display() {
	System.out.println("ID:"+id);
	System.out.println("Name:"+name);
	System.out.println("Gender:"+gender);
	certificate.certificationdisplay();
}

}
