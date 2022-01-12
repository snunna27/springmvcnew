package com.dxc.springcontroller

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.util.ArrayList
import java.util.List
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.dxc.model.Employee
import com.dxc.util.MyConnection

@Controller class EmployeeController {
	@GetMapping("/addnew") def String addNewEmployee() {
		return "addnewemployee"
	}

	@PostMapping("/saveemployee") def String saveNewEmployee(Model model, @RequestParam String username,
		@RequestParam String password, @RequestParam String fname, @RequestParam String lname,
		@RequestParam String salary) {
		System.out.println('''username «username»''')
		System.out.println('''password «password»''')
		System.out.println('''fname «fname»''')
		System.out.println('''lastname «lname»''')
		System.out.println('''salary «salary»''')
		var Connection con = MyConnection.getConnection()
		var String query = '''insert into employee values(null,'«»«username»','«»«password»','«»«fname»','«»«lname»','«»«salary»')'''
		try {
			var Statement statment = con.createStatement()
			statment.executeUpdate(query)
		} catch (Exception e) {
			e.printStackTrace()
		}

		var List<Employee> employeeList = new ArrayList<Employee>()
		var String querySelect = "select * from employee"
		try {
			var Statement st = con.createStatement()
			var ResultSet result = st.executeQuery(querySelect)
			while (result.next()) {
				// printing the record
				System.out.println('''id «result.getInt(1)»''')
				System.out.println('''username«result.getString(2)»''')
				System.out.println('''password «result.getString(3)»''')
				System.out.println('''First Name«result.getString(4)»''')
				System.out.println('''Last Name «result.getString(5)»''')
				System.out.println('''Salary «result.getString(6)»''')
				// storing into variable
				var int idDb = result.getInt(1)
				var String usernameDb = result.getString(2)
				var String passwordDb = result.getString(3)
				var String fnameDb = result.getString(4)
				var String lnameDb = result.getString(5)
				var int salaryDb = result.getInt(6)
				// store to employee class
				var Employee employee = new Employee()
				employee.setiD(idDb)
				employee.setUserName(usernameDb)
				employee.setPassword(passwordDb)
				employee.setFirstName(fnameDb)
				employee.setLastName(lnameDb)
				employee.setSalary(salaryDb)
				employeeList.add(employee)
			}
		} catch (Exception e) {
			e.printStackTrace()
		}

		model.addAttribute("employeelist", employeeList)
		return "home"
	}
}
