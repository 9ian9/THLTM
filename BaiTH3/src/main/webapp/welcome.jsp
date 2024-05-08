<%@page import="model.Bean.Wife"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			ArrayList<Wife> wifeArray = (ArrayList<Wife>) request.getAttribute("wifeArray");
			for(Wife item : wifeArray){
		%>
		
		<tr>
			<td><%=item.getName() %></td>
			<td><%=item.getAddress() %></td>
			<td><%=item.isAlive() %></td>
		</tr>
		
		<%}%>
	</table>
</body>
</html>