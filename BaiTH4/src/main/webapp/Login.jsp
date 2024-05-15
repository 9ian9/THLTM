<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	.login-form-input {
		background-color: olive;
	}
	body {
		display: flex;
		width: 100%;
		align-items: center;
		justify-content: center;
		height: 100%;
	}
	.login-form-wrapper {
		background-color: navy;
		padding : 20px;
		border-radius: 10px;
		display: flex;
		flex-direction: column;
		align-items: center;
		margin-top: 150px;
	}
	h1{
		color: white;
	}
	p{
		color: white;
	}
	.login-form-input{
		padding : 10px;
		margin: 0px 10px;
		border-radius: 10px;
	}	
	input[type="submit"] {
		margin: 10px;
		background-color: white;
		padding : 10px;
		border-radius: 10px;
	}
	form{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
</style>
<body>
	<h1></h1>
	<div class='login-form-wrapper'>
		<h1>Login</h1>
		<form action="CheckLoginServlet" method="post">
			<div class='login-form-item'>
				<p>Username :</p> 
				<input type="text" name="username" class='login-form-input'>
			</div>
			<div class='login-form-item'>
				<p>Password : </p>
				<input type="password" name="password" class='login-form-input'>
			</div>
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>