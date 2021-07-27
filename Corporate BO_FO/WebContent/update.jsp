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
 
          <%@page import="dao.CorporateDao,model.Corporate1"%>

	<%
		CorporateDao crDao = new CorporateDao();
		int id = (Integer.parseInt(request.getParameter("id")));
		Corporate1 u = crDao.getRecordById(id);
	%>

	<form action="CorporateController" method="get">

		<table>
			<tr>
				<td>Corporate Name:</td>
				<td><input type="text" name="name" value="<%=u.getName()%>" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"
					value="<%=u.getAddress()%>" /></td>
			</tr>
			<tr>

				<td>Phone Number:</td>
				<td><input type="number" name="phonenumber"
					value="<%=u.getPhonenumber()%>" /></td>

			</tr>
		</table>
		<!-- <td colspan="2"><input type="submit" name="action" value="update" /></td> -->
		<input type="hidden" name="id" value="<%=u.getId()%>" /> <input
			type="hidden" value="update" name="action" /> <input type="submit"
			value="update" />
	</form>
	<a href="index.jsp">Go Home</a>

    </body>
</html>      
                            
              