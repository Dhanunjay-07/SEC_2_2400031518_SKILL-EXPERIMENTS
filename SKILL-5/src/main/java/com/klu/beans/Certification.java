package com.klu.beans;

public class Certification {
private int id;
private String name;
private int dateofcompletion;
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
public int getDateofcompletion() {
	return dateofcompletion;
}
public void setDateofcompletion(int dateofcompletion) {
	this.dateofcompletion = dateofcompletion;
}
public void certificationdisplay() {
	System.out.println("ID:"+id);
	System.out.println("Name:"+name);
	System.out.println("DateOfCompletion:"+dateofcompletion);
}


}
