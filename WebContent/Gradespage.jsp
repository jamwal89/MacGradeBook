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
<form>
<table class="table table-bordered">
    <thead>
        <tr><th>Subject</th><th>Grade</th><th>Assignment</th></tr>
    </thead>
    <tbody>
    <c:forEach var="grade" items="${grades}">
        <tr><td><c:out value="${grade.subject}"/></td>
        <td><c:out value="${grade.grade}"/></td>
        <td><c:out value="${grade.assignment}"/></td>
        <td><fmt:formatDate value="${post.postdate}" pattern="yy-MMM-dd"/></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</form>
</body>
</html>