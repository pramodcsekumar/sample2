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
        <div class="us">
         <sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/training"
                           user="root"  password="root1234"/>
 
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from Account;
        </sql:query>
    
        <form>
            <table border="1">
                <caption>Account list</caption>
                <tr>
                   
                    <th>userId</th>
                    <th>AccountNumber</th>
                    <th>AccountName</th>
                    <th>Branch</th>
                    <th>currency</th>
                    <th>Balance</th>
                    <th>UserName</th>
                    <th>password</th>                 
                    <th colspan="2">Action</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                       
                        <td><c:out value="${row.userId}"/></td>
                        <td><c:out value="${row.AccountNumber}"/></td>
                        <td><c:out value="${row.AccountName}"/></td>
                        <td><c:out value="${row.Branch}"/></td>
                        <td><c:out value="${row.currency}"/></td>
                        <td><c:out value="${row.Balance}"/></td>
                        <td><c:out value="${row.UserName}"/></td>
                        <td><c:out value="${row.password}"/></td>
                           
                        <td><a href="update2.jsp?AccountNumber=<c:out value="${row.AccountNumber}"/>">Update</a></td>
                        <td><a href= "AccountController?AccountNumber=<c:out value="${row.AccountNumber}"/>&action=delete">Delete</a></td>
                         
                    </tr>
                </c:forEach>
            </table>
        </form>
        <a href="index.jsp">Go Home</a>
    </div>
</body>
</html>