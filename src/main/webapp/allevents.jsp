<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Events</title>
</head>
<body>
	<h1>All Events</h1>
	
	<table border=5 cellspacing=10 cellpadding=10 rules="all">
		<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Event</th>
		<th>Date</th>
		<th>Chief Guest</th>
		<th colspan=2>Action</th>
		
		</tr>
		
		<% 
		ResultSet rs=(ResultSet) request.getAttribute("rs");
		while(rs.next()){
			
		%>
		<tr>
		<td><%=  rs.getInt(1)%></td>
		<td><%=  rs.getString(2)%></td>
		<td><%=  rs.getString(3)%></td>
		<td><%=  rs.getString(4)%></td>
		<td><%=  rs.getString(5)%></td>
		<td><a href="delete?id=<%=  rs.getInt(1)%>"><button>Delete</button></a></td>
		<td><a href="updatepage?id=<%=  rs.getInt(1)%>"><button>UPDATE</button></a></td>
		</tr>
	
	<%
	}
	%>
	
	</table>


</body>
</html>