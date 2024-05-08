<%@page import="Models.JDBC.DB_Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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

.btn {
  border: 2px solid black;
  background-color: white;
  color: black;
  padding: 8px 16px;
  font-size: 15px;
  cursor: pointer;
  transition: 0.25s;
  border-radius: 20px;
  outline: none;
}
.edit_btn{
	background-color: gray;
  color: white;
  padding: 8px 16px;
  font-size: 10px;
  cursor: pointer;
  transition: 0.25s;
  outline: none;
  border:none;
  margin-left: 20px;
  border-radius: 20px;
}
.success {
  border-color: #4CAF50;
  color: green;
}

.success:hover {
  background-color: #4CAF50;
  color: white;
}

.danger {
  border-color: #f44336;
  color: red;
}

.danger:hover {
  background: #f44336;
  color: white;
}

.ConfirmedLbl{
  background-color: MediumSeaGreen;
  color: white;
  padding: 8px 16px;
  font-size: 15px;
  text-align: center;
}
.notfound{
		top: 50%;
        left: 50%;
        position: absolute;
        transform: translate(-50%, -50%);
        box-sizing: border-box;
        padding: 70px 30px;
}
.Alink{

		text-decoration: none;
		border: none;
        outline: none;
        height: 40px;
        background: DodgerBlue;
        color: #fff;
        font-size: 18px;
        border-radius: 20px;
        transition: 0.25s;
        padding: 8px 16px;
}
.Alink:hover{
  		cursor: pointer;
        background: #ffc107;
        color: #000;
}
input{
		border: none;
        border-bottom: 1px solid darkgray;
        background: transparent;
        outline: none;
        height: 40px;
        color: darkgray;
        font-size: 16px;
        transition: 0.25s;
        margin-left: 20px;
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
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-large">
  <a href="home.jsp" class="w3-bar-item w3-button w3-mobile">Trang chủ</a>
  <a href="myrequests.jsp" class="w3-bar-item w3-button w3-mobile on-click">Lịch sử giao dịch</a>
  <a href="rooms.jsp" class="w3-bar-item w3-button w3-mobile">Dịch vụ</a>
  <a href="about.jsp" class="w3-bar-item w3-button w3-mobile">Về chúng tôi</a>
  <a href="contact.jsp" class="w3-bar-item w3-button w3-mobile">Liên hệ</a>
  <a href="../logout.jsp" id="user_name_div" title="logout" class="w3-bar-item w3-button w3-right w3-mobile"><%= session.getAttribute( "LogedInUserName" ) %></a>
  <script type="text/javascript">
    var pp = document.getElementById('user_name_div').innerText;
    if(pp == "null"){
      window.location.href = "../login.jsp";
    }
  </script>
</div>

<!-- page content -->
<div style="width: 100%; min-height: 750px;">
		<div class="w3-container w3-margin-top" id="rooms">
			<h3>Các yêu cầu của tôi</h3>
			<div class="w3-row-padding w3-padding-16">
				<%
					try {
						Statement statement = null;
						ResultSet resultSet = null;
						String Countrow="";
						String CurrentUser = session.getAttribute("LogedInUserName").toString();
						
						DB_Connection obj_DB_Connection = new DB_Connection();
						Connection connection = obj_DB_Connection.get_connection();
						statement = connection.createStatement();
						String sql = "SELECT COUNT(id) FROM rooms Where RequestMadeBy = '" + CurrentUser + "'";
						resultSet = statement.executeQuery(sql);
						while (resultSet.next()) {
							Countrow = resultSet.getString(1);
							if(Countrow.equals("0")){
								%>

								<div class="notfound">
								<center><img alt="ntfound" src="../images/ntfound.png">
								<h4>Không tìm thấy yêu cầu nào</h4>
								<a href="home.jsp" class="Alink">Tạo một yêu cầu</a></</center>
								</div>

								<%
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>


				<%
					try {
						String CurrentUser = session.getAttribute("LogedInUserName").toString();
						Statement statement = null;
						ResultSet resultSet = null;

						DB_Connection obj_DB_Connection = new DB_Connection();
						Connection connection = obj_DB_Connection.get_connection();
						statement = connection.createStatement();
						String sql = "SELECT * FROM rooms Where RequestMadeBy = '" + CurrentUser + "' ORDER BY dateNtime ASC";
						
						resultSet = statement.executeQuery(sql);
						while (resultSet.next()) {
				%>

				<div class="w3-third w3-margin-bottom">
					<div class="w3-container w3-white">
						<table>
							<tr>
								<td><h3>Ngày gửi :</h3></td>
								<td><label
									style="font-family: monospace; color: gray; border: 2px solid gray; padding: 8px;">
										<%=resultSet.getString("dateNtime")%></label></td>
										<td><button  class="edit_btn" onclick="hide_show_inputs(<%=resultSet.getString("id")%>)" id="hide_show_inputs_btn_<%=resultSet.getString("id")%>">Edit</button></td>
							</tr>
						</table>
						
						<form action="../UpdateMyRequest" method="post">
						<ul>
							<li>Số lượng người lớn : 
								<b id="Adults_display_val_<%=resultSet.getString("id")%>"><%=resultSet.getString("Adults")%></b>
								<input type="number" name="Adults_update_input" id="Adults_update_input_<%=resultSet.getString("id")%>"  min="1" max="6" value='<%=resultSet.getString("Adults")%>' style="display: none;">
							</li>
							<li>Số lượng trẻ em : 
								<b id="Kids_display_val_<%=resultSet.getString("id")%>"><%=resultSet.getString("Kids")%></b>
								<input type="number" name="Kids_update_input" id="Kids_update_input_<%=resultSet.getString("id")%>" min="0" max="6"    value='<%=resultSet.getString("Kids")%>' style="display: none;">
							</li>
							<li>Ngày checkIn : 
								<b id="CheckIn_display_val_<%=resultSet.getString("id")%>"><%=resultSet.getString("CheckIn")%></b>
								<input type="date" name="CheckIn_update_input" id="CheckIn_update_input_<%=resultSet.getString("id")%>" required="required" value='<%=resultSet.getString("CheckIn")%>' style="display: none;">
							</li>
							<li>Ngày checkOut : 
								<b id="CheckOut_display_val_<%=resultSet.getString("id")%>"><%=resultSet.getString("CheckOut")%></b>
								<input type="date" name="CheckOut_update_input" id="CheckOut_update_input_<%=resultSet.getString("id")%>" required="required" value='<%=resultSet.getString("CheckOut")%>' style="display: none;">
							</li>
							<%
								if (resultSet.getString("Status").equals("1")) {
							%>
							<li>Số phòng : <b
								style="background-color: yellow; padding: 2px 8px 2px 8px;"><%=resultSet.getString("RoomNo")%></b></li>
								</form>
								<script type="text/javascript">
								 document.getElementById("hide_show_inputs_btn_<%=resultSet.getString("id")%>").style.display ="none";
								</script>
						</ul>
						<p class="ConfirmedLbl">Xác nhận</p>
						<%
							} else {
						%>
						</ul>
						
							<input style="display: none;" type="text" name="req_id"
								value='<%=resultSet.getString("id")%>'>
							<button type="submit" class="btn success" id="save_btn_<%=resultSet.getString("id")%>" 
								style="margin-left: 20px; margin-bottom: 20px; display: none;">Lưu</button>
						</form>
						<form action="../DeletRequestByUser" method="post">
							<input style="display: none;" type="text" name="req_id"
								value='<%=resultSet.getString("id")%>'>
							<button type="submit" class="btn danger" id="delete_btn_<%=resultSet.getString("id")%>"
								style="margin-left: 20px; margin-bottom: 20px;">Xóa</button>
						</form>
						<%
							}
						%>


					</div>
				</div>

				<%
					}
					%>

					<%
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>

			</div>

		</div>
	</div>

<!-- Footer -->
<footer class="w3-padding-16 w3-black w3-center w3-margin-top">
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

<script type="text/javascript">
	
	function hide_show_inputs(xx) {
		
		var hide_show_inputs_btn_txt = document.getElementById('hide_show_inputs_btn_'+xx+'').innerText;
		if(hide_show_inputs_btn_txt == 'Edit'){

			document.getElementById('hide_show_inputs_btn_'+xx+'').innerText = "Cancel";
			document.getElementById('hide_show_inputs_btn_'+xx+'').style.background = "red";
			document.getElementById('delete_btn_'+xx+'').style.display = "none";
			document.getElementById('save_btn_'+xx+'').style.display = "";

			document.getElementById('Adults_display_val_'+xx+'').style.display = "none";
			document.getElementById('Kids_display_val_'+xx+'').style.display = "none";
			document.getElementById('CheckIn_display_val_'+xx+'').style.display = "none";
			document.getElementById('CheckOut_display_val_'+xx+'').style.display = "none";

			document.getElementById('Adults_update_input_'+xx+'').style.display = "";
			document.getElementById('Kids_update_input_'+xx+'').style.display = "";
			document.getElementById('CheckIn_update_input_'+xx+'').style.display = "";
			document.getElementById('CheckOut_update_input_'+xx+'').style.display = "";

		}
		else{
			document.getElementById('hide_show_inputs_btn_'+xx+'').innerText = "Edit";
			document.getElementById('hide_show_inputs_btn_'+xx+'').style.background = "gray";
			document.getElementById('delete_btn_'+xx+'').style.display = "";
			document.getElementById('save_btn_'+xx+'').style.display = "none";

			document.getElementById('Adults_display_val_'+xx+'').style.display = "";
			document.getElementById('Kids_display_val_'+xx+'').style.display = "";
			document.getElementById('CheckIn_display_val_'+xx+'').style.display = "";
			document.getElementById('CheckOut_display_val_'+xx+'').style.display = "";

			document.getElementById('Adults_update_input_'+xx+'').style.display = "none";
			document.getElementById('Kids_update_input_'+xx+'').style.display = "none";
			document.getElementById('CheckIn_update_input_'+xx+'').style.display = "none";
			document.getElementById('CheckOut_update_input_'+xx+'').style.display = "none";
		}

		
	}

</script>

</body>
</html>
