<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>login</h1>
<div>${errMsg}</div>
<div>
	<form action="login" method="post">
		
	<div><input type="text" name="uid" placeholder="id" value="m1"></div>
	<div><input type="password" name="upw" placeholder="password" value="1234"></div> 
	<div><input type="submit" value="Login"></div>
	</form>	
</div>
<div>
	<a href="join">회원가입</a>
</div>