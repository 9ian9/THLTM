<%@page import="Model.BEAN.Account"%>
<%@page import="Model.BEAN.Faculity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Faculty</title>
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
    .btn-back {
        margin-bottom: 20px;
        color: #fff;
        background-color: #007bff;
        border-color: #007bff;
    }
    .btn-back:hover {
        color: #fff;
        background-color: #0056b3;
        border-color: #004085;
    }
    .form-container {
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #fff;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        font-weight: bold;
    }
    .alert {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            int mode = Integer.parseInt(request.getAttribute("mode") + "");
            Account updateAccount = (Account) request.getAttribute("updateAccount");
            String errorMessage = (String) request.getAttribute("errorMessage");
        %>
        <h1>Edit Account</h1>
        <a href="ViewListAccount" class="btn btn-back mb-3"><i class="fa-solid fa-backward"></i> Back</a>
        <div class="form-container">
            <form action="CRUDAccount?mode=<%= mode %>" method="post">
                <% if (mode == 3) { %>
                    <input type="hidden" name="id" value="<%= updateAccount.getId() %>">
                <% } %>
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" value="<%= updateAccount != null ? updateAccount.getUsername() : "" %>">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%= updateAccount != null ? updateAccount.getPassword() : "" %>">
                </div>
                <div class="form-group">
                    <label for="role">Role:</label>
                    <input readonly="readonly" type="text" class="form-control" id="role" name="role" value="<%= updateAccount != null ? (updateAccount.getRole()==1 ? "Admin" : "Student") : "Admin" %>">
                </div>
                <% if (errorMessage != null) { %>
                    <div class="alert alert-danger" role="alert">
                        <%= errorMessage %>
                    </div>
                <% } %>
                <button type="submit" class="btn btn-primary">Confirm</button>
                <button type="button" class="btn btn-secondary" onclick="window.location.reload();">Reset</button>
            </form>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/fd6bf6bce9.js" crossorigin="anonymous"></script>
</body>
</html>
