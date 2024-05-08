<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Sofitel</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="../images/logo.png">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

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
		<a href="home.jsp" class="w3-bar-item w3-button w3-mobile">Trang
			chủ</a> <a href="myrequests.jsp" class="w3-bar-item w3-button w3-mobile">Lịch
			sử giao dịch</a> <a href="rooms.jsp"
			class="w3-bar-item w3-button w3-mobile ">Dịch vụ</a> <a
			href="about.jsp" class="w3-bar-item w3-button w3-mobile on-click">Về
			chúng tôi</a> <a href="contact.jsp"
			class="w3-bar-item w3-button w3-mobile">Liên hệ</a> <a
			href="../logout.jsp" id="user_name_div" title="logout"
			class="w3-bar-item w3-button w3-right w3-mobile"><%=session.getAttribute("LogedInUserName")%></a>
		<script type="text/javascript">
			var pp = document.getElementById('user_name_div').innerText;
			if (pp == "null") {
				window.location.href = "../login.jsp";
			}
		</script>
	</div>

	<!-- page content -->
	<div style="width: 100%; min-height: 750px;">
		<div class="w3-row-padding" id="about">
			<div class="w3-col l4 12">
				<h3>Về chúng tôi</h3>
				<h6>Tại Mường Thanh, chúng tôi mời bạn cùng khởi hành chuyến đi
					tìm về không gian thanh thản chứa đựng những nét văn hóa mang đậm
					tinh thần bản sắc Việt, nơi con người gắn kết và thân ái gửi trao
					nhau tình cảm chân thành. Trải dọc khắp mọi vùng miền của đất nước
					Việt Nam xinh đẹp cùng các nước trong khu vực Đông Nam Á, Mường
					Thanh đồng hành cùng bạn ở khắp nơi, cho mọi hành trình, ở mọi giai
					đoạn của cuộc sống.</h6>
				<h6>Từ khách sạn đầu tiên tọa lạc ở Điện Biên Phủ, Việt Nam,
					Tập đoàn Khách sạn Mường Thanh đã phát triển thành chuỗi khách sạn
					cao cấp đạt chuẩn quốc tế với 60 khách sạn thành viên, phủ sóng
					khắp các địa phương tại Việt Nam và các nước Đông Nam Á. Hệ thống
					khách sạn Mường Thanh với 4 phân khúc: Mường Thanh Luxury, Mường
					Thanh Grand, Mường Thanh Holiday và Mường Thanh hướng đến việc phục
					vụ đa dạng nhu cầu của mọi du khách trong nước và quốc tế. Từ thiên
					nhiên núi cao hoang sơ, qua đồng bằng trù phú, miền biển trải dài
					tiếp nối những đô thị sôi động, thành phố lớn...... hệ thống khách
					sạn Mường Thanh song hành và mang đến sự hài lòng, tin yêu cho du
					khách trong và ngoài nước.</h6>
				<p>
					Chúng tôi chấp nhận thanh toán bằng: <i class="fa fa-credit-card w3-large"></i> <i
						class="fa fa-cc-mastercard w3-large"></i> <i
						class="fa fa-cc-amex w3-large"></i> <i
						class="fa fa-cc-cc-visa w3-large"></i><i
						class="fa fa-cc-paypal w3-large"></i>
				</p>
			</div>
			<div class="w3-col l8 12">
				<!-- Image of location/map -->
				<img src="../images/contact_image.jpg" class="w3-image w3-greyscale"
					style="width: 100%;">
			</div>
		</div>

		<div class="w3-row-padding w3-large w3-center" style="margin: 32px 0">
			<div class="w3-third">
				<i class="fa fa-map-marker w3-text-blue"></i>Địa chỉ: 962 Ngô Quyền, An Hải Bắc, Sơn Trà, Đà Nẵng
			</div>
			<div class="w3-third">
				<i class="fa fa-phone w3-text-blue"></i>Số điện thoại: 0236 3929 929
			</div>
			<div class="w3-third">
				<i class="fa fa-envelope w3-text-blue"></i> Email: TDT_Hotel@gmail.com
			</div>
		</div>

		<div class="w3-panel w3-leftbar w3-padding-32">
			<h6>
				<i class="fa fa-info w3-light-grey w3-padding w3-margin-right"></i>
				Ngoài ra chúng tôi còn cung cấp các dịch vụ khác như chăm sóc thú nuôi, chăm sóc trẻ em, gym, ...
			</h6>
		</div>

		<div class="w3-container">
			<h3>Về khách sạn của chúng tôi</h3>
			<h6>Bạn có thể tìm thấy khách sạn của chúng tôi ở mọi nơi ở đà nẵng:</h6>
		</div>

		<div class="w3-row-padding w3-padding-16 w3-text-white w3-large">
			<div class="w3-half w3-margin-bottom">
				<div class="w3-display-container">
					<img src="../images/PhuTho.jpg" alt="Phú Thọ"
						style="width: 100%"> <span
						class="w3-display-bottomleft w3-padding">Phú Thọ</span>
				</div>
			</div>
			<div class="w3-half">
				<div class="w3-row-padding" style="margin: 0 -16px">
					<div class="w3-half w3-margin-bottom">
						<div class="w3-display-container">
							<img src="../images/BacNinh.jpg" alt="Bắc Ninh"
								style="width: 100%"> <span
								class="w3-display-bottomleft w3-padding">Bắc Ninh</span>
						</div>
					</div>
					<div class="w3-half w3-margin-bottom">
						<div class="w3-display-container">
							<img src="../images/QuangNinh.jpg" alt="Quảng Ninh"
								style="width: 100%"> <span
								class="w3-display-bottomleft w3-padding">Quảng Ninh</span>
						</div>
					</div>
				</div>
				<div class="w3-row-padding" style="margin: 0 -16px">
					<div class="w3-half w3-margin-bottom">
						<div class="w3-display-container">
							<img src="../images/DaNang.jpg" alt="Đà Nẵng"
								style="width: 100%"> <span
								class="w3-display-bottomleft w3-padding">Đà Nẵng</span>
						</div>
					</div>
					<div class="w3-half w3-margin-bottom">
						<div class="w3-display-container">
							<img src="../images/NhaTrang.jpg" alt="Nha Trang"
								style="width: 100%"> <span
								class="w3-display-bottomleft w3-padding">Nha Trang</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div
			class="w3-container w3-padding-32 w3-black w3-opacity w3-card w3-hover-opacity-off"
			style="margin: 32px 0; background-color: #FFF2EB">
			<h2>Nhận ưu đãi tốt nhất đầu tiên!</h2>
			<p>Tham gia bản tin của chúng tôi.</p>
			<label>E-mail</label> <input class="w3-input w3-border" type="text"
				placeholder="Nhập địa chỉ email vào">
			<button type="button" class="w3-button w3-blue w3-margin-top">Đăng kí</button>
		</div>

	</div>

	<!-- Footer -->
	<footer class="w3-padding-16 w3-center w3-margin-top">
		<h5>Tìm kiếm chúng tôi trên</h5>
		<div class="w3-xlarge w3-padding-16">
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
	</footer>


</body>
</html>
