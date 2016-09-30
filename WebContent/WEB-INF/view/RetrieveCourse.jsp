<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="getCourseById" method="post">
Course id: <input type="text" name="courseId">
<input type="submit" value="GETCOURSE">
</form> -->

<form action="getCourseByName" method="post">
Course name: <input type="text" name="courseName">
<input type="submit" value="GETCOURSE">
</form> 

</body>
</html>