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
<form action ="UpdateServlet" method="post" onClick="update">
<table class="table table-bordered">
    <thead>
        <tr><th>StudentID</th><th>Grade</th><th>Subject</th><th>Assignment</th><th>Assignment Type</th><th>Record ID</th></tr>
    </thead>
    <tbody>
    <c:forEach var="allgrade" items="${allgrades}">
     	<tr>
     		<td><c:out value="${allgrade.userid}"/></td>
     		<td><c:out value="${allgrade.grade}"/></td>
     		<td><c:out value="${allgrade.subject}"/></td>
     		<td><c:out value="${allgrade.assignment}"/></td>
     		<td><c:out value="${allgrade.assignmnettype}"/></td>
     		<td><c:out value="${allgrade.gbid}"/></td>
      
        </tr>
    </c:forEach>
  
    </tbody>
    </table>
    <p>Enter the record which needs to be updated</p> 
    
    <input type="text" name="RecordID"> <br>
	<input type="submit" value="update">	
  	
    </form>
  <form action="GradebookuserServlet" method="post">
  <input type="submit" value="Logout">
  <input type="hidden" name="action" value="Logout">
  </form>
</body>
</html>