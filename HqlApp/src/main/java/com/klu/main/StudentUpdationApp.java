package com.klu.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.klu.entity.Student;


public class StudentUpdationApp {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		/*
		 * String hql="update Student set fee=fee+100 where course =:courses";
		 * MutationQuery query = s.createMutationQuery(hql);
		 * query.setParameter("courses", "java"); int res=query.executeUpdate();
		 * System.out.println(res); //s.close();
		 * 
		 * 
		 * String hqldelete="Delete from Student where course =:courses"; //
		 * s=sf.openSession(); MutationQuery query1 = s.createMutationQuery(hqldelete);
		 * query1.setParameter("courses", "c++"); int res1=query1.executeUpdate();
		 * System.out.println(res1); s.close(); sf.close();
		 */
		//insert more than one data is inserted in to a table
		String name=null;
		String course=null;
		double fee=0.0;
		Student st=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no.of rows");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			sc.nextLine();
			System.out.println("enter student name:");
			name=sc.nextLine();
			System.out.println("enter the student course:");
			course=sc.nextLine();
			System.out.println("enter the student course fee:");
			fee=sc.nextDouble();
			//create the student object;
			st=new Student();
			st.setName(name);
			st.setCourse(course);
			st.setFee(fee);
			s.persist(st);
		}
		tx.commit();
		s.close();
		sf.close();
	}
}
