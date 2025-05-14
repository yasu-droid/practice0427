<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css">
<script src=""></script>
</head>
<body class="login">
	<h1>ログインページ</h1>
	<div id="loginBox">
	<div id="loginTitle">Login</div>
		<form>
			<p id="loginText">
				<input type="text" ID="loginID" name="ID" placeholder=" loginID">
				<br> <input type="password" ID="loginPw" name="loginPw"
					placeholder=" Password">
			</p>
			<p>
				<input type="button" value="Log in" id="loginBtn">
			</p>

		</form>
	</div>

</body>
</html>