package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Product;

public class ProductApp {

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = conf.buildSessionFactory();

        Product p = new Product();

        /*
        // INSERT
        Session s = sf.openSession();

        p.setName("Laptop");
        p.setDescription("Gaming Laptop");
        p.setPrice(80000);
        p.setQuantity(10);

        Transaction tx = s.beginTransaction();
        s.persist(p);
        tx.commit();

        s.close();

        System.out.println("Product Inserted");
        */


        // READ
        Session s = sf.openSession();

        Product product = s.find(Product.class, 2);

        if(product != null) {
            System.out.println("Product Found");
            System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice());
        }

        s.close();



        // UPDATE
        s = sf.openSession();

        product = s.find(Product.class, 2);

        if(product != null) {

            product.setPrice(75000);
            product.setQuantity(8);

            Transaction tx = s.beginTransaction();

            s.merge(product);

            tx.commit();

            System.out.println("Product Updated");
        }

        s.close();


       s = sf.openSession();
     product = s.find(Product.class, 2);

     if(product != null) {

        Transaction tx = s.beginTransaction();

s.remove(product); 

         tx.commit();

          System.out.println("Product Deleted");
     }

     s.close();

        sf.close();
    }
}