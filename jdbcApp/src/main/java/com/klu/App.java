package com.klu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
    	//step-1: loading driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        //step-2:get the connection with DB
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sec2", "root", "557611@Yes");
        if(connection !=null)
        	System.out.println("connected.........");
        else
        	System.out.println("not connected.........");
        
        
        String q="insert into student values(1001,'raj','raj@gmail.com')";
        
        Statement stmt=connection.createStatement();
        int n=stmt.executeUpdate(q);
        System.out.println("value of n:"+n);
        connection.close();
    }
}
