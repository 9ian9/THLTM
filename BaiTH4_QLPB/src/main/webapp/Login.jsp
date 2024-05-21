<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-form-wrapper {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }
    h1 {
        margin-bottom: 20px;
        color: #333333;
    }
    .login-form-item {
        margin-bottom: 15px;
        text-align: left;
    }
    .login-form-item label {
        display: block;
        margin-bottom: 5px;
        color: #666666;
    }
    .login-form-input {
        width: 100%;
        padding: 10px;
        border: 1px solid #dddddd;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .login-form-input:focus {
        outline: none;
        border-color: #007BFF;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007BFF;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .error-message {
        color: #ff0000;
        margin-bottom: 10px;
    }
</style>
</head>
<body>
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <div class="login-form-wrapper">
        <h1>Login</h1>
        <form action="CheckLoginServlet" method="post">
            <div class="login-form-item">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="login-form-input" required>
            </div>
            <div class="login-form-item">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="login-form-input" required>
            </div>
            <% if (errorMessage != null) { %>
                <p class="error-message"><%= errorMessage %></p>
            <% } %>
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
