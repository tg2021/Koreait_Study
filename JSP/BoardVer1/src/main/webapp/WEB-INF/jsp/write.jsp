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
	<!-- method에 적을 수 있는건 get post만 가능 -->
	
		<div>
			제목 : <input type="text" name="title"> <!-- name이 키값 -->
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<!-- 트리거 @WebServlet("/write")로 날아감 -->
			<input type="submit" value="글쓰기"> 
			<input type="reset" value="초기화" >
			<input type="button" value="뒤로가기" onclick="script:history.back();">
		</div>
	</form>
</body>
</html>