<%@page import="Model.BEAN.Account"%>
<%@page import="Model.BEAN.Faculity"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/fd6bf6bce9.js" crossorigin="anonymous">
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
    ArrayList<Faculity> listFaculity = (ArrayList<Faculity>) request.getAttribute("listFaculity");
    Account accountInfo = (Account) session.getAttribute("accountInfo");
    %>
    <div class="container">
        <h1>Welcome, admin <%=accountInfo.getUsername()%></h1>
        <div class='action-buttons'>
        	<a href="Login.jsp" class="btn btn-back mb-3"><i class="fa-solid fa-right-from-bracket fa-rotate-180"></i></a>
            <a href="CRUDFaculity?mode=1" class="btn btn-back mb-3"><i class="fa-solid fa-plus"></i></a>
            <a href="ViewListAccount" class="btn btn-back mb-3">View list Account</a>
        </div>
        <%
            if (listFaculity == null || listFaculity.isEmpty()) {
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
                    <th>Name</th>
                    <th>Classes</th>
                    <th>Teachers</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                for(Faculity item : listFaculity)
                {
                %>
                <tr>
                    <td><%=item.getId() %></td>
                    <td><%=item.getName() %></td>
                    <td><a href="ViewListClass?faculityId=<%= item.getId()%>" class="btn btn-info">List Classes</a></td>
                    <td><a href="ViewListTeacher?faculityId=<%=item.getId()%>" class="btn btn-info">List Teachers</a></td>
                    <td><a href="CRUDFaculity?mode=3&id=<%=item.getId()%>" class="btn btn-warning"><i class="fa-regular fa-pen-to-square"></i></a></td>
                    <td><a href="CRUDFaculity?mode=4&id=<%=item.getId()%>" class="btn btn-danger"><i class="fa fa-trash"></i></a></td>
                </tr>
                <%} %>
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
