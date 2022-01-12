package com.dxc.springcontroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.model.Employee;
import com.dxc.util.MyConnection;

//@Controller -which will convert class to controller to take http request
//@GetMapping --take the http get request
//@PathVariable --which will read the value in the path url /3
//@RequestParam  --request take the data from request   ?id=3

@Controller
public class EmployeeController {
	
	
	@GetMapping("/editemployee/{id}")
	public String editEmpployee(Model model, @PathVariable Integer id) 
	{
		System.out.println("@PathVariable "+id);
		Connection con=MyConnection.getConnection();
		try
		{
		Statement st=con.createStatement();
	    String querySelectByID="select * from employee where id='"+id+"'";
		ResultSet rs=st.executeQuery(querySelectByID);
		Employee employee=new Employee();
		
		while(rs.next())
		{
			employee.setiD(rs.getInt(1));
			employee.setUserName(rs.getString(2));
			employee.setPassword(rs.getString(3));
			
			employee.setFirstName(rs.getString(4));
			employee.setLastName(rs.getString(5));
			employee.setSalary(rs.getInt(6));
		}
		
		model.addAttribute("employee",employee);
		}
		catch(Exception e)
		{
			
		}
		finally {
			try
			{
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return "editemployee";
	}
	
	@GetMapping("/addnew")
	public String addNewEmployee()
	{
		return "addnewemployee";
	}
	
	@PostMapping("/saveemployee")
	public String saveNewEmployee(Model model,@RequestParam String username,
			                    @RequestParam String password,
			                    @RequestParam String fname,
			                    @RequestParam String lname,
			                    @RequestParam String salary
			                    )
	{
	
		
		
		
		System.out.println("username "+username);
		System.out.println("password "+password);
		System.out.println("fname "+fname);
		System.out.println("lastname "+lname);
		System.out.println("salary "+salary);
	
		//adding the new employee start
		
		Connection con=MyConnection.getConnection();
		
		String query="insert into employee values(null,'"+ username+"','"+password+"','"+fname+"','"+lname+"','"+salary+"')";
		
		try
		{
		
		Statement statment=con.createStatement();
		statment.executeUpdate(query);
		
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		//adding the new employee ends
		
		
		//selected the employee list starts
		
       List<Employee> employeeList=new ArrayList<Employee>();
		
		String querySelect="select * from employee order  by id desc";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(querySelect);
		
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
		
		//selected the employee list ends
		
		model.addAttribute("employeelist",employeeList);
			
		return "home";
	}
	
	
	@PostMapping("/updateemployee")
	public String saveNewEmployee(Model model,@RequestParam String username,
			                    @RequestParam String password,
			                    @RequestParam String fname,
			                    @RequestParam String lname,
			                    @RequestParam String salary,
			                    @RequestParam String id
			                    )
	{
	
		
		
		
		System.out.println("username "+username);
		System.out.println("password "+password);
		System.out.println("fname "+fname);
		System.out.println("lastname "+lname);
		System.out.println("salary "+salary);
	
		//adding the new employee start
		
		Connection con=MyConnection.getConnection();
		
		//String query="insert into employee values(null,'"+ username+"','"+password+"','"+fname+"','"+lname+"','"+salary+"')";
		String queryUpdate="update employee set username='"+ username+"',password='"+password+"',firstname='"+fname+"',lastname='"+lname+"',salary="+salary+" where id="+id;
		System.out.println(queryUpdate);
		try
		{
		
		Statement statment=con.createStatement();
		statment.executeUpdate(queryUpdate);
		
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		//adding the new employee ends
		
		
		//selected the employee list starts
		
       List<Employee> employeeList=new ArrayList<Employee>();
		
		String querySelect="select * from employee order  by id desc";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(querySelect);
		
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
		
		//selected the employee list ends
		
		model.addAttribute("employeelist",employeeList);
			
		return "home";
	}
	
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(Model model,@PathVariable String id)
	{
	
		
	
		//adding the new employee start
		
		Connection con=MyConnection.getConnection();
		
		//String query="insert into employee values(null,'"+ username+"','"+password+"','"+fname+"','"+lname+"','"+salary+"')";
		String queryDelete="delete from employee where id="+id;
		System.out.println(queryDelete);
		try
		{
		
		Statement statment=con.createStatement();
		statment.executeUpdate(queryDelete);
		
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		//adding the new employee ends
		
		
		//selected the employee list starts
		
       List<Employee> employeeList=new ArrayList<Employee>();
		
		String querySelect="select * from employee order  by id desc";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(querySelect);
		
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
		
		//selected the employee list ends
		
		model.addAttribute("employeelist",employeeList);
			
		return "home";
	}
	
}
