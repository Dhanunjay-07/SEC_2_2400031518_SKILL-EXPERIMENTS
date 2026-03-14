package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Product;

public class ProductApp {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		Product p1 = new Product("Laptop","Electronics",50000,10);
		Product p2 = new Product("Mouse","Electronics",500,5);
		Product p3 = new Product("Keyboard","Electronics",2000,20);
		Product p4 = new Product("Chair","Furniture",2500,100);
		Product p5 = new Product("Table","Furniture",3000,10);
		Product p6 = new Product("Pen","Stationary",20,100);

		s.persist(p1);
		s.persist(p2);
		s.persist(p3);
		s.persist(p4);
		s.persist(p5);
		s.persist(p6);

		tx.commit();
		s.close();

		// HQL sorting ascending
		String hql="from Product order by price ASC";
		s=sf.openSession();
		Query<Product>query=s.createQuery(hql, Product.class);
		List<Product>L=query.getResultList();
		System.out.println("ascending order by price");
		L.forEach(a->System.out.println(a));
		s.close();

		// HQL sorting descending
		String hql1="from Product order by price DESC";
		s=sf.openSession();
		Query<Product>query1=s.createQuery(hql1, Product.class);
		List<Product>L1=query1.getResultList();
		System.out.println("descending order by price");
		L1.forEach(b->System.out.println(b));
		s.close();

		// sort by quantity highest first
		String hql2="from Product order by quantity DESC";
		s=sf.openSession();
		Query<Product>query2=s.createQuery(hql2, Product.class);
		List<Product>L2=query2.getResultList();
		System.out.println("highest quantity first");
		L2.forEach(c->System.out.println(c));
		s.close();

		// pagination first 3
		String pg="from Product";
		s=sf.openSession();
		Query<Product>q1=s.createQuery(pg, Product.class);
		q1.setFirstResult(0);
		q1.setMaxResults(3);
		List<Product>l1=q1.getResultList();
		System.out.println("first 3 products");
		l1.forEach(d->System.out.println(d));
		s.close();

		// pagination next 3
		s=sf.openSession();
		Query<Product>q2=s.createQuery(pg, Product.class);
		q2.setFirstResult(3);
		q2.setMaxResults(3);
		List<Product>l2=q2.getResultList();
		System.out.println("next 3 products");
		l2.forEach(e->System.out.println(e));
		s.close();

		// aggregate functions
		String count="select count(*) from Product";
		String min="select min(price) from Product";
		String max="select max(price) from Product";

		s=sf.openSession();

		Query<Long>a1=s.createQuery(count,Long.class);
		Long c1=a1.getSingleResult();
		System.out.println("total products: "+c1);

		Query<Double>a2=s.createQuery(min,Double.class);
		Double c2=a2.getSingleResult();
		System.out.println("minimum price: "+c2);

		Query<Double>a3=s.createQuery(max,Double.class);
		Double c3=a3.getSingleResult();
		System.out.println("maximum price: "+c3);

		s.close();

		// where clause price range
		String hql3="from Product where price between 1000 and 10000";
		s=sf.openSession();
		Query<Product>query3=s.createQuery(hql3, Product.class);
		List<Product>L3=query3.getResultList();
		System.out.println("price between 1000 and 10000");
		L3.forEach(f->System.out.println(f));
		s.close();

		// like queries
		String like1="from Product where name like 'M%'";
		s=sf.openSession();
		Query<Product>q3=s.createQuery(like1,Product.class);
		List<Product>l3=q3.getResultList();
		System.out.println("name starting with M");
		l3.forEach(g->System.out.println(g));
		s.close();
		
		String like2="from Product where name like '%p'";
		s=sf.openSession();
		Query<Product>q4=s.createQuery(like2,Product.class);
		List<Product>l4=q4.getResultList();
		System.out.println("name ending with p");
		l4.forEach(h->System.out.println(h));
		s.close();

		String like3="from Product where name like '%top%'";
		s=sf.openSession();
		Query<Product>q5=s.createQuery(like3,Product.class);
		List<Product>l5=q5.getResultList();
		System.out.println("name containing top");
		l5.forEach(i->System.out.println(i));
		s.close();
		sf.close();
	}
}