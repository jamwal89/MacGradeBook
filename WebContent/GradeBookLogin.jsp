<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" /><!-- fixes date not displaying correctly in Eclipse browser -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>Home Page</title>
<jsp:include page="Bootstrap.jsp"></jsp:include>
</head>

<body>
<form action="GradebookuserServlet" method="post">
<h1>Welcome to Grades</h1>

<br>
<br>
 Login:<br>
 <input type="text" name="username">
<br>
<br>

Password:<br>
<input type="password" name="password"> <br>
<input type = "Submit" value ="Log In">
<input type="reset" value="Reset"> <br>
</form>
</body>
</html>
