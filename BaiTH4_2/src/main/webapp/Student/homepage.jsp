<%@page import="Model.BEAN.Faculity"%>
<%@page import="Model.BEAN.Grade"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Model.BEAN.Account"%>
<%@page import="Model.BEAN.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Info</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/fd6bf6bce9.css" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    table {
        width: 50%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 10px 24px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 20px 0;
        cursor: pointer;
    }
</style>
</head>
<body>    
	<%
		Student studentInfo = (Student) request.getAttribute("studentInfo");
		Account accountInfo	= (Account) request.getAttribute("accountInfo"); 
		Grade classInfo = (Grade) request.getAttribute("classInfo");
		Faculity faculityInfo = (Faculity) request.getAttribute("faculityInfo");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	%>
	<a href="Login.jsp" class="btn btn-back mb-3"><i class="fa-solid fa-right-from-bracket fa-rotate-180"></i></a>
    <h1>Welcome Student</h1>
    <table>
        <tr>
            <th>ID</th>
            <td><%=studentInfo.getId() %></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><%=studentInfo.getName() %></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><%=studentInfo.getBirthday().format(formatter) %></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td><%=studentInfo.getGender() %></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><%=studentInfo.getTel() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%=studentInfo.getEmail() %></td>
        </tr>
        <tr>
            <th>Year of Student</th>
            <td><%=studentInfo.getYearOfStudent() %></td>
        </tr>
        <tr>
            <th>Class Name</th>
            <td><%=classInfo.getName() %></td>
        </tr>
        <tr>
            <th>Faculity </th>
            <td><%=faculityInfo.getName() %></td>
        </tr>
        <tr>
            <th>Account username</th>
            <td><%=accountInfo.getUsername() %></td>
        </tr>
        <tr>
            <th>Account password</th>
            <td><%=accountInfo.getPassword() %></td>
        </tr>
    </table>
    <a href="CRUDStudent?mode=3&id=<%= studentInfo.getId() %>&isStudent=true" class="button">Update Info</a>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fd6bf6bce9.js" crossorigin="anonymous"></script>
</body>
</html>
