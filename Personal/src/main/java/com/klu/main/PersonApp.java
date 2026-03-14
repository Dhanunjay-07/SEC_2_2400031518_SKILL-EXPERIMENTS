package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Person;

public class PersonApp {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Person p1=new Person("yesh",10);
		Person p2=new Person("bujji",20);
		s.persist(p1);
		s.persist(p2);
		Transaction tx=s.beginTransaction();
		tx.commit();
		s.close();
	}
}
