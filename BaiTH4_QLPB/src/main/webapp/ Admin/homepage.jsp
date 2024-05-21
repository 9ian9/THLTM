<%@page import="model.bean.Account"%>
<%@page import="model.bean.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Admin</title>
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
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px;
        }
        h1 {
            color: #333333;
            text-align: center;
            margin-bottom: 20px;
        }
        .alert {
            color: #856404;
            background-color: #fff3cd;
            border: 1px solid #ffeeba;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #dddddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <%
    ArrayList<Department> listDepartment = (ArrayList<Department>) request.getAttribute("listDepartment");
    Account accountInfo = (Account) session.getAttribute("accountInfo");
    %>
    <div class="container">
        <h1>Welcome, admin <%=accountInfo.getUsername()%></h1>
        <%
            if (listDepartment == null || listDepartment.isEmpty()) {
        %>
            <div class="alert">
                No data
            </div>
        <%
            } else {
        %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <%
                for(Department item : listDepartment)
                {
                %>
                <tr>
                    <td><%=item.getId() %></td>
                    <td><%=item.getName() %></td>
                </tr>
                <%} %>
            </tbody>
        </table>
        <%} %>
    </div>
</body>
</html>
