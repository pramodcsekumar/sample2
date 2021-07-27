<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
    <head>
        <title>SELECT Operation</title>
        <link rel="stylesheet" href="style.css"></link>
</head>
<body background="https://cdn.pixabay.com/photo/2017/03/15/09/00/crocus-2145539__340.jpg">
  <div class="co" >    
    
    
 
         <sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/training"
                           user="root"  password="root1234"/>
 
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from corporate;
        </sql:query>
    
    <%-- <c:forEach items="${list}" var="u">
	<tr><td>${u.getId()}</td><td>${u.getName()}<td>${u.getEmail()}</td><td>${u.getGender()}</td><td>${u.getCountry()}</td><td><a href="editform.jsp?id=${u.getId()}">Edit</a></td><td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>
</c:forEach> --%>
    
        <form>
            <table border="1">
                <caption>Corporate List</caption>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone Number</th>
                  
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.id}"/></td>
                        <td><c:out value="${row.name}"/></td>
                         <td><c:out value="${row.address}"/></td>
                          <td><c:out value="${row.phonenumber}"/></td>
                           
                        <td><a href="update.jsp?id=<c:out value="${row.id}"/>">Update</a></td>
                        <td><a href= "CorporateController?id=<c:out value="${row.id}"/>&action=delete">Delete</a></td>
                         
                    </tr>
                </c:forEach>
            </table>
        </form>
        <a href="index.jsp">Go Home</a>
        </div>    
   
</body>
</html>