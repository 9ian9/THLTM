<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Model.BEAN.Account"%>
<%@page import="Model.BEAN.Student"%>
<%@page import="Model.BEAN.Grade"%>
<%@page import="Model.BEAN.Faculity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Faculty</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://kit.fontawesome.com/fd6bf6bce9.css"
	crossorigin="anonymous">
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
            Student updateStudent = (Student) request.getAttribute("updateStudent");
            Account updateAccount = (Account) request.getAttribute("updateAccount");
            String errorMessage = (String) request.getAttribute("errorMessage");
        	Grade classInfo = (Grade) request.getAttribute("classInfo");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String isStudent = request.getAttribute("isStudent") + "";
        %>
		<a href="javascript:void(0);" onclick="history.back();"
			class="btn btn-back mb-3"> <i class="fa-solid fa-backward"></i>
			Back
		</a>
		<div class="form-container">
			<form action="CRUDStudent?mode=<%= mode %>" method="post">
				<input type="hidden" name="classId" value="<%= classInfo.getId() %>">
				<% if (mode == 3) { %>
				<input type="hidden" name="id" value="<%= updateStudent.getId() %>">
				<% } %>
				<% if (!isStudent.equals("") || isStudent != null) { %>
				<input type="hidden" name="isStudent" value="<%=isStudent %>">
				<% } %>
				
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" name="name"
						value="<%= updateStudent != null ? updateStudent.getName() : "" %>">
				</div>
				<div class="form-group">
					<label for="birthday">Birthday:</label> <input type="text"
						class="form-control" id="birthday" name="birthday"
						value="<%= updateStudent != null ? updateStudent.getBirthday().format(formatter) : "" %>">
				</div>
				<div class="form-group">
					<label for="gender">Gender:</label> <input type="text"
						class="form-control" id="gender" name="gender"
						value="<%= updateStudent != null ? updateStudent.getGender() : "" %>">
				</div>
				<div class="form-group">
					<label for="tel">Telephone:</label> <input type="text"
						class="form-control" id="tel" name="tel"
						value="<%= updateStudent != null ? updateStudent.getTel() : "" %>">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="text"
						class="form-control" id="email" name="email"
						value="<%= updateStudent != null ? updateStudent.getEmail() : "" %>">
				</div>
				<div class="form-group">
					<label for="yearOfStudent">Year student:</label> <input type="text"
						class="form-control" id="yearOfStudent" name="yearOfStudent"
						value="<%= updateStudent != null ? updateStudent.getYearOfStudent() : "" %>">
				</div>
				<div class="form-group">
					<label for="className">Class:</label> <input type="text"
						class="form-control" readonly="readonly" id="className"
						name="className"
						value="<%= classInfo != null ? classInfo.getName() : "" %>">
				</div>
				<div class="form-group">
					<label for="username">account's username:</label> <input
						type="text" class="form-control" id="username" name="username"
						value="<%= updateAccount != null ? updateAccount.getUsername() : "" %>">
				</div>
				<div class="form-group">
					<label for="password">account's password:</label> <input
						type="password" class="form-control" id="password" name="password"
						value="<%= updateAccount != null ? updateAccount.getPassword() : "" %>">
				</div>
				<% if (errorMessage != null) { %>
				<div class="alert alert-danger" role="alert">
					<%= errorMessage %>
				</div>
				<% } %>
				<button type="submit" class="btn btn-primary">Confirm</button>
				<button type="button" class="btn btn-secondary"
					onclick="window.location.reload();">Reset</button>
			</form>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/fd6bf6bce9.js"
		crossorigin="anonymous"></script>
</body>
</html>