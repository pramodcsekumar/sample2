<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%@page import="dao.UserDao,model.User1"%> 
          <%
	       UserDao crDao = new UserDao();
	       int userId= (Integer.parseInt(request.getParameter("userId")));
	       User1 u = crDao.getRecordById(userId);
	      %> 
          
        <form action="UserController">
        <table>
        <tr>
            <td>userId:</td>
             <td><input type="number" name="userId" value="<%=request.getParameter("userId")%>" /></td>
             </tr>
		 <tr>
            <td>Id:</td>
		     <td><input type="number" name="id" value="<%=request.getParameter("id")%>" /></td>  
		 </tr>
		<tr>
            <td>name:</td>	
		     <td><input type="text" name="name" value="<%=request.getParameter("name")%>" /></td>
			 </tr>
			<tr>
				<td>Department:</td>
				<td><input type="text" name="department" value="<%=request.getParameter("department")%>" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="<%=request.getParameter("address")%>" /></td>
			</tr>
			<tr>
				<td>PhoneNumber:</td>
				<td><input type="tel" name="phonenumber" value="<%=request.getParameter("phonenumber")%>" /></td>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="update" /></td>
			</tr>
		</table>
        </form>
    </body>
</html>      
                            
              