<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Sofitel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="../images/logo.png">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.w3-xlarge i {
    color: #FFF2EB;
}
body {
	background-color: #DFB6B2;
}
.w3-bar{
	background-color: #190019;
}	
.w3-bar-item {
	color: #FBE4D8;
	background-color: #190019;
}
.w3-button:hover {
	background-color: #DFB6B2 !important;
	color : #2B124C !important;
}
.w3-container {
	background-color: #190019;
	color : #FBE4D8;
	opacity: 0.9;
}
footer {
	background-color: #190019;
	color : #FBE4D8;
}
.on-click {
	background-color: #DFB6B2 !important;
	color : #2B124C !important;
}
</style>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-large">
  <a href="home.jsp" class="w3-bar-item w3-button w3-mobile">Trang chủ</a>
  <a href="myrequests.jsp" class="w3-bar-item w3-button w3-mobile">Lịch sử giao dịch</a>
  <a href="rooms.jsp" class="w3-bar-item w3-button w3-mobile">Dịch vụ</a>
  <a href="about.jsp" class="w3-bar-item w3-button w3-mobile">Về chúng tôi</a>
  <a href="contact.jsp" class="w3-bar-item w3-button w3-mobile on-click">Liên hệ</a>
  <a href="../logout.jsp" id="user_name_div" title="logout" class="w3-bar-item w3-button w3-right w3-mobile"><%= session.getAttribute( "LogedInUserName" ) %></a>
  <script type="text/javascript">
    var pp = document.getElementById('user_name_div').innerText;
    if(pp == "null"){
      window.location.href = "../login.jsp";
    }
  </script>
</div>

	<!-- page content -->
	<div style="width: 100%; min-height: 750px; background-color: #FFF2EB">
		<div class="w3-container" id="contact">
			<h2>Liên hệ</h2>
			<p>Nếu như bạn có bất kì câu hỏi này, xin hãy để lại lời nhắn dưới đây</p>
			<i class="fa fa-map-marker w3-text-blue" style="width: 30px"></i>
			Sơn Trà, Đà Nẵng<br> <i class="fa fa-phone w3-text-blue"
				style="width: 30px"></i> Điện thoại : 0236 3929 929<br> <i
				class="fa fa-envelope w3-text-blue" style="width: 30px"> </i> Email:
			TXT_Hotel@gmail.com<br>
			<form action="../SendMessageByUser" method="post">
				<input type="text" name="current_user" value='<%= session.getAttribute( "LogedInUserName" ) %>' style="display: none;">
				<p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Nhập vào email" required name="Email"></p>
				<p>
					<input class="w3-input w3-padding-16 w3-border" type="text"
						placeholder="Lời nhắn" required name="Message">
				</p>
				<p>
					<button class="w3-button w3-black w3-padding-large" type="submit">Gửi lời nhăn</button>
				</p>
			</form>
		</div>
	</div>

	<!-- Footer -->
<footer class="w3-padding-16 w3-center w3-margin-top">
  <h5>Tìm kiếm chúng tôi trên</h5>
  <div class="w3-xlarge w3-padding-16">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
  </div>
</footer>


</body>
</html>
