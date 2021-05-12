<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>스크립틀릿 히해를 하였는가 미션1</div>
	<div>for문을 이용하여 1 ~ 10 세로방향으로 찍히도록 해주세요</div>
	<div>각 숫자들은 div로 감싸주세요</div>
	
	
	<% 
	for(int i = 1; i < 11; i++) {
		out.print("<div>");
		out.print(i);
		out.print("</div>");
	} 
	%>
	<hr>
	<% for(int i = 1; i < 11; i++) { %>
		<div><%=i %></div>
	<% }%>
	
</body>
</html>