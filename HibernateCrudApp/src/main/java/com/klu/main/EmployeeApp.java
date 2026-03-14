package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Employee;
import com.klu.entity.Product;

public class EmployeeApp {

    public static void main(String[] args) {

    		//retrieving configuration object
    		    Configuration conf = new Configuration().configure("hibernate.cfg.xml");
    		    //retrieving sessionfactory object
    		    SessionFactory sf = conf.buildSessionFactory();
    		    //Employee e = new Employee();
    		    
    		    //INSERT Data
    		    /*
    		     * Employee e = new Employee(1004,"Kiran","kiran@gmail.com"); //transient state
    		     * //retrieve Session object to get the connection to DB Session s =
    		     * sf.openSession(); //retrieve Transaction object to perform DB operation
    		     * Transaction tx = s.beginTransaction();
    		     * 
    		     * //store emp data into table s.persist(e); //persistent state //store it
    		     * permanently into db tx.commit();
    		     * s.close();//detached state
    		     */
    		    
    		    
    		    
    		    //READ Data
    		    //Session s = sf.openSession();
    		    //read single record from db using find() 
    		     //e = s.find(Employee.class, 1001);
    		    //read single record from db using either load() or get()
    		    //e = s.get(Employee.class, 10001); // eager loading approach
    		    //e = s.load(Employee.class, 10001); //lazy loading approach 
    		    /*
    		     * diiference between get and load:
    		     * get:
    		     * -> get directly hits the db and get the details of primary key related row
    		     * -> if the record is there, it will get the data and stores into actual obj.
    		     * -> if it is  not there, it returns null
    		     * load:
    		     * -> load will creates proxy for the entity. and it directly will not hit
    		     *    the db. i.e.., it follows lazy loading
    		     * -> whenever developer needs the data by force, then only it hits database.
    		     * -> if data is there it will return it otherwise it return ObjectNotFound 
    		     *      exception.
    		     */
    		    //System.out.println(e);
    		    //s.close();
    		    
				/*
				 * //update //load record from db Session s=sf.openSession();
				 * e=s.find(Employee.class, 1001); //do the column modification based on
				 * requirement e.setEmail("rajasekhara@gmail.com"); e.setEname("Raja sekhar");
				 * //update the above details in session s.merge(e); //update permanently in the
				 * db Transaction tx=s.beginTransaction(); tx.commit(); //close the session
				 * s.close(); //System.out.println("employee updated"); //sf.close();
				 */ 
    		          //delete
    		          //retrieve db record
						/*
						 * Session s=sf.openSession(); e=s.find(Employee.class,1001); //delete from
						 * session s.remove(e); //to delete permanently Transaction
						 * tx=s.beginTransaction(); tx.commit(); s.close();
						 */
    		    
    		    Product p=new Product();
    		    Session s =sf.openSession();
    		    p.setPname("laptop");
    		    p.setCost(1000);
    		    s.persist(p);
    		    Transaction tx=s.beginTransaction();
    		    tx.commit();   
    		    }
}