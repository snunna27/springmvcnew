package com.dxc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	
	public static void main(String arg[])
	{

     Connection connection=getConnection();
     	
	}
	

	public static Connection getConnection()
	{
		
		Connection connection=null;
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?characterEncoding=utf8","root","root");
		if(connection!=null)
		{
		 	System.out.println("connected !");
		}
		else
		{
		  System.out.println("no connected");	
		}
		}
		catch(Exception e)
		{
		   e.printStackTrace();	
		}
		return connection;
			
	}
	

}
