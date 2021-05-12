<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<h1>글수정</h1>
	
	<form action="/mod3" method="post">
		<input type="hidden" name="iboard" value="${param.iboard }">
		 <div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 :
			<textarea name="ctnt" rows="10" cols="22">${data.ctnt}</textarea>
		</div>
		<div>
			<input type="submit" value="수정"> 
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>