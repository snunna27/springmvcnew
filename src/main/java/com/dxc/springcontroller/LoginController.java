package com.dxc.springcontroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.model.Employee;
import com.dxc.util.MyConnection;

@Controller
public class LoginController {

Connection con=MyConnection.getConnection();	

@GetMapping("/")	
public String home()
{

	return "login";
}

@PostMapping("/checklogin")	
public String checklogin(Model model,@RequestParam String username,@RequestParam String password)
{

	String returnpage="login";
	System.out.println("Username "+username);
	System.out.println("password "+password);
	
	String usernameServer="admin";
	String passwordServer="admin";
			
	if(username.equalsIgnoreCase(usernameServer) && password.equalsIgnoreCase(passwordServer))
	{
		
		List<Employee> employeeList=new ArrayList<Employee>();
		
		String query="select * from employee";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(query);
		
		while(result.next())
		{
			//printing the record
			System.out.println("id "+result.getInt(1));
			System.out.println("username"+result.getString(2));
			System.out.println("password "+result.getString(3));
			System.out.println("First Name"+result.getString(4));
			System.out.println("Last Name "+result.getString(5));
			System.out.println("Salary "+result.getString(6));
			
			//storing into variable
			int idDb=result.getInt(1);
			String usernameDb=result.getString(2);
			String passwordDb=result.getString(3);
			String fnameDb=result.getString(4);
			String lnameDb=result.getString(5);
			int salaryDb=result.getInt(6);
			//store to employee class
			Employee employee=new Employee();
			
			employee.setiD(idDb);
			employee.setUserName(usernameDb);
			employee.setPassword(passwordDb);
			employee.setFirstName(fnameDb);
			employee.setLastName(lnameDb);
			employee.setSalary(salaryDb);
			employeeList.add(employee);
			
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		model.addAttribute("employeelist",employeeList);
		returnpage="home";
	}
	
	return returnpage;
}


	
	
}
