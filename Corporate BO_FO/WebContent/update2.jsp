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
 
          <%@page import="dao.AccountDao,model.Account"%> 
          <%
	       AccountDao crDao = new AccountDao();
	       int AccountNumber= (Integer.parseInt(request.getParameter("AccountNumber")));
	       Account u = crDao.getRecordById(AccountNumber);
	      %> 
           
        <form action="AccountController">
        <table>
            <tr>
				<td>userId:</td>
				<td><input type="text" name="userId" value="<%=request.getParameter("userId")%>" />	</td>
			</tr>
             <tr>
				<td>AccountNumber:</td>
				<td><input type="number" name="AccountNumber" value="<%=request.getParameter("AccountNumber")%>" /></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="UserName" value="<%=request.getParameter("UserName")%>" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" value="<%=request.getParameter("password")%>" /></td>
			</tr>
		
			<tr>
				<td>AccountName:</td>
				<td><input type="text" name="AccountName" value="<%=request.getParameter("AccountName")%>" /></td>
			</tr>
			<tr>
				<td>Branch:</td>
				<td><input type="number" name="Branch" value="<%=request.getParameter("Branch")%>" /></td>
			</tr>
			<tr>
				<td>Currency:</td>
				<td><input type="number" name="Currency" value="<%=request.getParameter("Currency")%>" /></td>
				</tr>
				<tr>
				<td>Balance:</td>
				<td><input type="number" name="Balance" value="<%=request.getParameter("Balance")%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="update" /></td>
			</tr>
		</table>
        </form>
    </body>
</html>      
                            
              