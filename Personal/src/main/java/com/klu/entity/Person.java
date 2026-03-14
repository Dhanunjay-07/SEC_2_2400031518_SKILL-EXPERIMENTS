package com.klu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private long pnum;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String pname, long pnum) {
		super();
		this.pname = pname;
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getPnum() {
		return pnum;
	}
	public void setPnum(long pnum) {
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pnum=" + pnum + "]";
	}
	
}
