<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/write3" method="post">

		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 :
			<textarea name="ctnt" rows="10" cols="22"></textarea>
		</div>
		<div>
			<input type="submit" value="등록"> <input type="reset"
				value="초기화">
		</div>



	</form>
</body>
</html>