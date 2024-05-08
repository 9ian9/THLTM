<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>TDT Hotel</title>
    <link rel="icon" type="image/png" href="images/Logo_2.png">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<style type="text/css">
    body {
        margin: 0;
        padding: 0;
        background-color: #DFB6B2;
        font-family: sans-serif;
    }

    h1 {
        margin: 0;
        padding: 0 0 20px;
        text-align: center;
        font-size: 30px;
    }

    .loginbox {
        width: 320px;
        height: 550px;
        background-color: #FBE4D8;
        color: #2B124C	;
        top: 50%;
        left: 50%;
        position: absolute;
        transform: translate(-50%, -50%);
        box-sizing: border-box;
        padding: 70px 30px;
        border-radius: 20px;
        box-shadow: 5px 10px #888888;

    }

    .avatar {
        width: 100px;
        height: 100px;
        border-radius: 50%;
        position: absolute;
        top: -50px;
        left: calc(50% - 50px);
        background-color: #2B124C;
    }


    .loginbox p {
        margin: 0;
        padding: 0;
        font-weight: bold;
        color: #2B124C;
    }

    .loginbox input {
        width: 100%;
        margin-bottom: 20px;
    }

    .loginbox input[type="text"],
    input[type="password"],
    input[type="email"] {
        border: none;
        border-bottom: 1px solid darkgray;
        background: transparent;
        outline: none;
        height: 40px;
        color: #4D4D8D;
        font-size: 16px;
        transition: 0.25s;
    }

    .loginbox input[type="text"]:focus,
    input[type="password"]:focus,
    input[type="email"]:focus {
        border-bottom: 2px solid #2B124C;
    }

    .loginbox input[type="submit"] {
        border: none;
        outline: none;
        height: 40px;
        background: #190019;
        color: #fff;
        font-size: 18px;
        border-radius: 20px;
        transition: 0.25s;
    }

    .loginbox input[type="submit"]:hover {
        cursor: pointer;
        background: #C78E88;
        color: #000;
    }

    .loginbox a {
        text-decoration: none;
        font-size: 12px;
        line-height: 20px;
        color: #2B124C;
        transition: 0.25s;
    }

    .loginbox a:hover {
        color: #C78E88;
    }

    .error {
        color: #FF7800;
    }

    ::placeholder {
        color: #ddd;
        opacity: 1;
        /* Firefox */
    }

    :-ms-input-placeholder {
        /* Internet Explorer 10-11 */
        color: #8B8B94;
    }

    ::-ms-input-placeholder {
        /* Microsoft Edge */
        color: #8B8B94;
    }
</style>

<body>

    <div class="loginbox">
        <img src="images/Logo_1.png" class="avatar">
        <h1>Đăng kí</h1>
        <form action="SignupServerlet" method="post">
            <p>Tài khoản</p>
            <input type="text" name="newuser" placeholder="Nhập tài khoản" required="required">
            <p>Mật khẩu</p>
            <input type="password" name="newpass" placeholder="Nhập mật khẩu" required="required">
            <p>Xác nhận</p>
            <input type="password" name="newconpass" placeholder="Xác nhận lại mật khẩu" required="required">
            <p>Email</p>
            <input type="email" name="newemail" placeholder="Nhập email" required="required">
            <input type="submit" name="login" value="Đăng kí"><br>
            <a href="login.jsp">Bạn đã có tài khoản? Đăng nhập ở đây..</a>
        </form>
    </div>

</body>


</html>