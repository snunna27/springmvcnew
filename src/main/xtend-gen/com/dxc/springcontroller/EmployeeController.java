package com.dxc.springcontroller;

import com.dxc.model.Employee;
import com.dxc.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SuppressWarnings("all")
public class EmployeeController {
  @GetMapping("/addnew")
  public String addNewEmployee() {
    return "addnewemployee";
  }
  
  @PostMapping("/saveemployee")
  public String saveNewEmployee(final Model model, @RequestParam final String username, @RequestParam final String password, @RequestParam final String fname, @RequestParam final String lname, @RequestParam final String salary) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("username ");
    _builder.append(username);
    System.out.println(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("password ");
    _builder_1.append(password);
    System.out.println(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("fname ");
    _builder_2.append(fname);
    System.out.println(_builder_2);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("lastname ");
    _builder_3.append(lname);
    System.out.println(_builder_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("salary ");
    _builder_4.append(salary);
    System.out.println(_builder_4);
    Connection con = MyConnection.getConnection();
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("insert into employee values(null,\'");
    _builder_5.append(username);
    _builder_5.append("\',\'");
    _builder_5.append(password);
    _builder_5.append("\',\'");
    _builder_5.append(fname);
    _builder_5.append("\',\'");
    _builder_5.append(lname);
    _builder_5.append("\',\'");
    _builder_5.append(salary);
    _builder_5.append("\')");
    String query = _builder_5.toString();
    try {
      Statement statment = con.createStatement();
      statment.executeUpdate(query);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
      } else {
        COMPILE ERROR : 'org.eclipse.xtext.xbase.lib.Exceptions' could not be found on the classpath!
      }
    }
    List<Employee> employeeList = new ArrayList<Employee>();
    String querySelect = "select * from employee";
    try {
      Statement st = con.createStatement();
      ResultSet result = st.executeQuery(querySelect);
      while (result.next()) {
        {
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("id ");
          int _int = result.getInt(1);
          _builder_6.append(_int);
          System.out.println(_builder_6);
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("username");
          String _string = result.getString(2);
          _builder_7.append(_string);
          System.out.println(_builder_7);
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("password ");
          String _string_1 = result.getString(3);
          _builder_8.append(_string_1);
          System.out.println(_builder_8);
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("First Name");
          String _string_2 = result.getString(4);
          _builder_9.append(_string_2);
          System.out.println(_builder_9);
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append("Last Name ");
          String _string_3 = result.getString(5);
          _builder_10.append(_string_3);
          System.out.println(_builder_10);
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("Salary ");
          String _string_4 = result.getString(6);
          _builder_11.append(_string_4);
          System.out.println(_builder_11);
          int idDb = result.getInt(1);
          String usernameDb = result.getString(2);
          String passwordDb = result.getString(3);
          String fnameDb = result.getString(4);
          String lnameDb = result.getString(5);
          int salaryDb = result.getInt(6);
          Employee employee = new Employee();
          employee.setiD(Integer.valueOf(idDb));
          employee.setUserName(usernameDb);
          employee.setPassword(passwordDb);
          employee.setFirstName(fnameDb);
          employee.setLastName(lnameDb);
          employee.setSalary(Integer.valueOf(salaryDb));
          employeeList.add(employee);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
      } else {
        COMPILE ERROR : 'org.eclipse.xtext.xbase.lib.Exceptions' could not be found on the classpath!
      }
    }
    model.addAttribute("employeelist", employeeList);
    return "home";
  }
}
