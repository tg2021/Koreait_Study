<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h1>글쓰기</h1>
	
	<form action="/write" method="post">
		<div><a href="/list">돌아가기</a></div>
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
			<input type="reset" value="초기화">
		</div>
	</form>
	
</body>
</html>