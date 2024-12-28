<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update page</h1>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	%>

	<form action="update">
		<input type="text" name="id" value="<%=rs.getInt(1)%>"
			placeholder="Enter the event ID"> <input type="text"
			name="title" value="<%=rs.getString(2)%>"
			placeholder="Enter the event Title"> <input type="text"
			name="loc" value="<%=rs.getString(3)%>"
			placeholder="Enter the event Location"> <input type="text"
			name="date" value="<%=rs.getString(4)%>"
			placeholder="Enter the event Date"> <input type="text"
			name="guest" value="<%=rs.getString(5)%>"
			placeholder="Enter the event Chief Guest ">
		<button type="submit">SUBMIT</button>
	</form>

</body>
</html>