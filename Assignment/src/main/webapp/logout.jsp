<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TDT Hotel</title>
<link rel="icon" type="image/png" href="images/Logo_2.png">
</head>
<body>
<p id="usertype_check" style="display: none;"><%=session.getAttribute("LogedInUserType")%></p>
</body>
<script type="text/javascript">
	var usertype_check_val = document.getElementById('usertype_check').innerText;
	var action = confirm("Bạn có chắc là bạn muốn đăng xuất chứ ?");

	if (action == true) {
		window.location.href = "login.jsp";
	} else {
		if (usertype_check_val == "admin") {
			window.location.href = "admin/home.jsp";
		} else {
			window.location.href = "user/home.jsp";
		}
	}
</script>

</html>