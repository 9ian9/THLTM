<%@page import="model.Bean.Wife"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	font-size: 16px;
	text-align: left;
}

th, td {
	padding: 12px 15px;
	border: 1px solid #ddd;
	text-align: center;
}

th {
	background-color: #f2f2f2;
	color: #333;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>isAlive</th>
			</tr>
		</thead>
		<%
		ArrayList<Wife> wifeArray = (ArrayList<Wife>) request.getAttribute("wifeArray");
		for (Wife item : wifeArray) {
		%>

		<tbody>
			<tr>
				<td><%=item.getName()%></td>
				<td><%=item.getAddress()%></td>
				<td><%=item.isAlive()%></td>
			</tr>
		</tbody>

		<%
		}
		%>
	</table>
</body>
</html>