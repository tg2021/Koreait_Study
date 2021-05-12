<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<% 
		int a = 10;
		int b = 20;
		int c = a + b;
		
		out.print("<div>");
		out.print(c);
		out.print("</div>");
	%>
	<hr>
	<div><%=c + 1 %></div>
</body>
</html>