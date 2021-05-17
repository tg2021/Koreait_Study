<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form action="join" method="post">
			<div>아이디 : <input type="text" name="uid" placeholder="id"></div>
			<div>패스워드 : <input type="password" name="upw" placeholder="password"></div>
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div>
			성별 : 
			<label>여성 <input type="radio" name="gender" value="0" checked="checked"></label>
			<label>남성 <input type="radio" name="gender" value="1"></label>	
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</body>
</html>