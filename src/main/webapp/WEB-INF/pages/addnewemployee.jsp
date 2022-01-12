<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Employee Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="#">Home</a></li>
   
      <li class="active"><a href="addnew">Add New Employee</a></li>
     
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome <%=request.getAttribute("username") %> </a></li>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
<form class="form-horizontal" action='saveemployee' method="POST">
  <fieldset>
    <div id="legend">
      <legend class="">Register</legend>
    </div>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="username">Username</label>
      <div class="controls">
        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
    
      </div>
    </div>
     <div class="control-group">
      <!-- Password-->
      <label class="control-label" for="password">Password</label>
      <div class="controls">
        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
       
      </div>
    </div>
    <div class="control-group">
      <!-- E-mail -->
      <label class="control-label" for="email">First Name</label>
      <div class="controls">
        <input type="text" id="fname" name="fname" placeholder="" class="input-xlarge">
        
      </div>
    </div>
 

  <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="password_confirm">Last Name</label>
      <div class="controls">
        <input type="text" id="lname" name="lname" placeholder="" class="input-xlarge">
     
      </div>
    </div>
   
    
      <div class="control-group">
      <!-- Password -->
      <label class="control-label"  for="password_confirm">salary</label>
      <div class="controls">
        <input type="text" id="salary" name="salary" placeholder="" class="input-xlarge">
     
      </div>
    </div>
 
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
  </fieldset>
</form>

</div>
</body>
</html>