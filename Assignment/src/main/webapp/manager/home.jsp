<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>TDT Hotel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="../images/Logo_2.png">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.w3-xlarge i {
    color: #FFF2EB;
}
body {
	background-color: #FFF2EB;
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
<body>

<!-- Navigation Bar -->
	<div class="w3-bar w3-large">
		<a href="home.jsp" class="w3-bar-item w3-button w3-mobile on-click">Trang chủ</a> 
		<a href="allrequests.jsp" class="w3-bar-item w3-button w3-mobile ">Lịch sử giao dịch</a> 
		<a href="rooms.jsp" class="w3-bar-item w3-button w3-mobile ">Dịch vụ</a> 
		<a href="about.jsp" class="w3-bar-item w3-button w3-mobile ">Về chúng tôi</a> 
		<a href="contact.jsp" class="w3-bar-item w3-button w3-mobile">Liên hệ</a> 
		<a href="../logout.jsp" id="user_name_div" title="logout" class="w3-bar-item w3-button w3-right w3-mobile"><%=session.getAttribute("LogedInUserName")%></a>
		<script type="text/javascript">
			var pp = document.getElementById('user_name_div').innerText;
			if (pp == "null") {
				window.location.href = "../login.jsp";
			}
		</script>
	</div>

<!-- Header -->
<header class="w3-display-container w3-content" style="max-width:1500px;">
  <img class="w3-image" src="../images/background.jpg" alt="The Hotel" style="min-width:1000px" width="1500" height="800">
  <div class="w3-display-left w3-padding w3-col l6 m8">
    <div  class="w3-container" >
      <h2><img src="../images/Logo_1.png" style="width: 40px;height: 40px;margin-right: 20px;">TDT Hotel xin kính chào quý khách</h2>
    </div>
  </div>
</header>


<!-- Footer -->
<footer class="w3-padding-16 w3-center w3-margin-top">
  <h5>Find Us On</h5>
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
