<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CorporateController">
  <input type="hidden" value="${param.id}" name="id" />
  <input type="hidden" value="delete" name="action"/>
  <input type="submit" value="delete"/>
</form>

</body>
</html>