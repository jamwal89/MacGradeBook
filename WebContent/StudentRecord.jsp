<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="DetailUpdateServlet" method="post" onclick="update" >
<h1>Student Details</h1>
<br>
UserID:
<input type="text" name="UserID" value="${student.userid }">
<br>
<br>
Subject:
<input type="text" name="Subject" value="${student.subject }">
<br>
<br>
Assignment:
<input type="text" name="Assignment" value="${student.assignment }">

<br>
<br>
Grade:
<input type="text" name="Grade" value="${student.grade }">
<input type="submit" value="update">	
  
</form>
</body>
</html>