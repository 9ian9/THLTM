<%@page import="Model.BEAN.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.BEAN.Account"%>
<%@page import="Model.BEAN.Grade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/fd6bf6bce9.css" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h1 {
        margin-bottom: 20px;
    }
    .table {
        margin-top: 20px;
    }
    .fa-trash, .fa-pen-to-square {
        cursor: pointer;
    }
    .fa-trash:hover, .fa-pen-to-square:hover {
        color: red;
    }
    .fa-backward:hover {
        color: #74C0FC;
    }
    .btn-back, .btn-plus {
        color: #fff;
        background-color: #007bff;
        border-color: #007bff;
        margin-right: 10px;
    }
    .btn-back:hover, .btn-plus:hover {
        color: #fff;
        background-color: #0056b3;
        border-color: #004085;
    }
    .action-buttons {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }
</style>
</head>
<body>
    <%
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        ArrayList<Account> listAccount = (ArrayList<Account>) request.getAttribute("listAccount");
    %>
    
    <div class="container">
        <h1>Welcome, admin "<%= accountInfo.getUsername() %>"</h1>
	    <div class="action-buttons">    
	        <a href="ViewListFaculity" class="btn btn-back mb-3"><i class="fa-solid fa-backward"></i></a>
	        <a href="CRUDAccount?mode=1" class="btn btn-back mb-3"><i class="fa-solid fa-plus"></i></a>
        </div>
                <%
            if (listAccount == null || listAccount.isEmpty()) {
        %>
            <div class="alert alert-warning" role="alert">
                No data
            </div>
        <%
            } else {
        %>
        <table class="table table-striped table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Account item : listAccount) {
                %>
                <tr>
                    <td><%= item.getId() %></td>
                    <td><%= item.getUsername() %></td>
                    <td><%= item.getPassword() %></td>
                    <td><%= item.getRole()==1 ? "admin" : "student" %></td>
                    <td><a href="CRUDAccount?mode=3&id=<%= item.getId() %>" class="btn btn-warning"><i class="fa fa-pen-to-square"></i></a></td>
                    <td><a href="CRUDAccount?mode=4&id=<%= item.getId() %>" class="btn btn-danger"><i class="fa fa-trash"></i></a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <%} %>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/fd6bf6bce9.js" crossorigin="anonymous"></script>
</body>
</html>
