<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AccountController">
  <input type="hidden" value="${param.AccountNumber}" name="AccountNumber" />
  <input type="hidden" value="delete" name="action"/>
  <input type="submit" value="delete"/>
</form>

</body>
</html>