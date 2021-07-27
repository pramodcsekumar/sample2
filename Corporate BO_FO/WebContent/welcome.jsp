<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="style1.css"></link>
<script src="https://kit.fontawesome.com/yourcode.js"></script>
</head>
<body>

<%

if(session.getAttribute("username")==null){
response.sendRedirect("login.jsp");
}

%>

<nav>
  <input type="checkbox" id="check">
  <label for="check"  class="checkbtn">
  <i class="fas fa-bars"></i>
</label>
<label class="wel">Welcome Alan</label>
  <ul>
      <li><a href="Corporateuser.html">Corporate Setup</a></li>
      <li><a href="Usersetup.html">User Setup</a></li>
      <li><a href="Account.html">Account Setup</a></li>
       <li><a href="logout.jsp">LogOut</a></li>
  </ul>
</nav>
<section></section>
</body>
</html>