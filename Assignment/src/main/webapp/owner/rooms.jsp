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

.w3-bar {
	background-color: #190019;
}

.w3-bar-item {
	color: #FBE4D8;
	background-color: #190019;
}

.w3-button:hover {
	background-color: #DFB6B2 !important;
	color: #2B124C !important;
}

.w3-container {
	background-color: #190019;
	color: #FBE4D8;
	opacity: 0.9;
}

footer {
	background-color: #190019;
	color : #FBE4D8;
}

.on-click {
	background-color: #DFB6B2 !important;
	color: #2B124C !important;
}
.w3-panel {
	background-color: #190019 !important;
	color: #FBE4D8 !important;
}

</style>
<body>

<!-- Navigation Bar -->
<div class="w3-bar w3-large">
  <a href="home.jsp" class="w3-bar-item w3-button w3-mobile">Trang chủ</a>
  <a href="allrequests.jsp" class="w3-bar-item w3-button w3-mobile">Lịch sử giao dịch</a>
  <a href="rooms.jsp" class="w3-bar-item w3-button w3-mobile on-click">Dịch vụ</a>
  <a href="about.jsp" class="w3-bar-item w3-button w3-mobile ">Về chúng tôi</a>
  <a href="contact.jsp" class="w3-bar-item w3-button w3-mobile">Liên hệ</a>
  <a href="../logout.jsp" id="user_name_div" title="logout" class="w3-bar-item w3-button w3-right w3-mobile"><%= session.getAttribute( "LogedInUserName" ) %></a>
  <script type="text/javascript">
    var pp = document.getElementById('user_name_div').innerText;
    if(pp == "null"){
      window.location.href = "../login.jsp";
    }
  </script>
</div>

	<div class="w3-container w3-margin-top" id="rooms">
		<h3>Dịch vụ phòng ở chúng tôi</h3>
		<p>Hãy tự nhiên như ở nhà là khẩu hiệu của chúng tôi. Chúng tôi sẽ cung cấp cho bạn những dịch vụ tốt nhất. Cùng những giấc ngủ ngon và và những ngày nghỉ ngơi tốt.</p>
	</div>


	<div class="w3-row-padding w3-padding-16">
    <div class="w3-third w3-margin-bottom">
      <img src="../images/Room_1.jpg" alt="Norway" style="width:100%">
      <div class="w3-container w3-white">
        <h3>Phòng đơn</h3>
        <h6 class="w3-opacity">Chỉ từ 499.000</h6>
        <p>Giường đơn</p>
        <p>15m<sup>2</sup></p>
        <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i></p>
      </div>
    </div>
    <div class="w3-third w3-margin-bottom">
      <img src="../images/Room_2.jpg" alt="Norway" style="width:100%">
      <div class="w3-container w3-white">
        <h3>Phòng đôi</h3>
        <h6 class="w3-opacity">Chỉ từ 999.000</h6>
        <p>Giường đơn kích thước bự</p>
        <p>25m<sup>2</sup></p>
        <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i></p>
      </div>
    </div>
    <div class="w3-third w3-margin-bottom">
      <img src="../images/Room_3.jpg" alt="Norway" style="width:100%">
      <div class="w3-container w3-white">
        <h3>Phòng V.I.P</h3>
        <h6 class="w3-opacity">From $199</h6>
        <p>Giường hạng sang</p>
        <p>40m<sup>2</sup></p>
        <p class="w3-large"><i class="fa fa-bath"></i> <i class="fa fa-phone"></i> <i class="fa fa-wifi"></i> <i class="fa fa-tv"></i> <i class="fa fa-glass"></i> <i class="fa fa-cutlery"></i></p>
      </div>
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
