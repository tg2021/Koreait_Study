<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<div>${errMsg}</div>
	<div>
		<form action="login" method="post">
			<div>
				<input type="text" name="uid" placeholder="id"> 
			</div>
			<div>
				<input type="password" name="upw" placeholder="password"> 
			</div>
			<div>
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
	<div>
		<a href="join">회원가입</a>
	</div>
</body>
</html>