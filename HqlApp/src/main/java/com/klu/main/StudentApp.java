 package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Student;

public class StudentApp {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		String hql="from Student where course= :course";
		Query<Student>query=s.createQuery(hql, Student.class);
		query.setParameter("course", "java");
		List<Student>L=query.getResultList();
		System.out.println("student details");
		L.forEach(St->System.out.println(St));
		s.close();
		String hql1="from Student where fee >=:fees";
		s=sf.openSession();
		Query<Student>query1=s.createQuery(hql1,Student.class);
		query1.setParameter("fees",10000);
		List<Student>L1=query1.getResultList();
		System.out.println("fee is greater than 10000");
		L1.forEach(St1->System.out.println(St1));
		s.close();
		//hql fetch data using where clause by  using named parameter 
		String hql2="from Student where course=?1 and fee>=?2";
		s=sf.openSession();
		Query<Student>query2=s.createQuery(hql2, Student.class);
		query2.setParameter(1,"java");
		query2.setParameter(2, 12000);
		List<Student>L2=query2.getResultList();
		System.out.println("student details:");
		L2.forEach(A->System.out.println(A));
		s.close();
		//Hql: using to create in descending order using hql;
		String hql3="from Student order by fee DESC";
		s=sf.openSession();
		Query<Student>querey3=s.createQuery(hql3,Student.class);
		List<Student>L3=querey3.getResultList();
		System.out.println("details in descending order");
		L3.forEach(B->System.out.println(B));
		s.close();
		//hql:using aggregate function
		String count="Select count(*) from Student";
		String sum="Select  sum(fee) from Student";
		String min="Select min(fee) from Student";
		String max="select max(fee) from Student";
		String avg="select avg(fee) from Student";
		s=sf.openSession();
		Query<Long>q1=s.createQuery(count, Long.class);
		Long c1 = q1.getSingleResult();
		System.out.println("no.of  student record: "+c1);
		Query<Double>q2=s.createQuery(sum, Double.class);
		Double c2 = q2.getSingleResult();
		System.out.println("no.of  student fee sum: "+c2);
		Query<Double>q3=s.createQuery(max, Double.class);
		Double c3 = q3.getSingleResult();
		System.out.println("no.of  student max fee record: "+c3);
		Query<Double>q4=s.createQuery(min, Double.class);
		Double c4 = q4.getSingleResult();
		System.out.println("no.of  student min record: "+c4);
		Query<Double>q5=s.createQuery(avg, Double.class);
		Double c5 = q5.getSingleResult();
		System.out.println("no.of  student avg record: "+c5);
		s.close();
		//hql: pagination (displaying specific no.of records per page)
		String pg="from Student";
		s=sf.openSession();
		Query<Student>q6=s.createQuery(pg, Student.class);
		q6.setFirstResult(0);
		q6.setMaxResults(3);
		List<Student>l1=q6.getResultList();
		System.out.println("print the element using pagination:");
		l1.forEach(c->System.out.println(c));
		s.close();
		sf.close();
	}
}
