package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Employee;

import jakarta.persistence.Tuple;

public class EmployeeApp {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		/*
		 * Employee e1 = new Employee("Yesh","yesh@gmail.com"); Employee e2 = new
		 * Employee("dhanu","dhanu@gmail.com"); Employee e3 = new
		 * Employee("dp","dp@gmail.com"); s.persist(e1); s.persist(e2); s.persist(e3);
		 * Transaction tx = s.beginTransaction(); tx.commit(); s.close();
		 */
		String Hql = "from Employee";
		Query<Employee> query = s.createQuery(Hql, Employee.class);
		List<Employee> L = query.getResultList();
		System.out.println("employee details in lamda expressions:");
		L.forEach(emp -> System.out.println(emp));
		System.out.println("employee details in enhanced loop:");
		for (Employee e : L) {
			//System.out.println("empid:"+e.getId());
			System.out.println("empName:"+e.getEname());
			System.out.println("empEmail:"+e.getEmail());
			System.out.println("-------------------------");
		}
		s.close();
		String hql1 = "select ename,email from Employee";
		s = sf.openSession();
		Query<Tuple> query2 = s.createQuery(hql1, Tuple.class);
		List<Tuple> L1 = query2.getResultList();
		System.out.println("employee partial details using foreach:");
		for (Tuple t : L1) {
			System.out.println("Emp Name:" + t.get(0));
			System.out.println("Emp Email:" + t.get(1));
			System.out.println("------------------------");
		}
		s.close();
		sf.close();
	}
}
