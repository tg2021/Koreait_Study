<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
	<%
	String name = "홍길동";
	pageContext.setAttribute("name", "A");
	request.setAttribute("name", "B");
	session.setAttribute("name", "C");
	application.setAttribute("name", "D");
	%>
	
--%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일${no}</title>
</head>
<body>
	<h1>디테일</h1>
	<!-- 키값 : String no = request.getParameter("no");의 "no"가 키값-->
	<!--  String name = "홍길동"; 은 el식으로 사용할 수 없다.
	
	<!-- setAttribute만 el식으로 사용가능 -->

	<!-- <div>2. ${vo.ctnt}</div> -->
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="${no}">
			<input type="submit" value="삭제">
		</form>
		<a href="/mod?no=${no }"><button>수정</button></a>
	</div>
	<div>제목 : ${data.title}</div>
	<div>${data.ctnt}</div>
</body>
</html>