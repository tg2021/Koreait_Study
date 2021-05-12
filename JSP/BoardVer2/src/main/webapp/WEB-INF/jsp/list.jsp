<%@page import="java.util.*"%>
<%@page import="com.koreait.board2.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> jstl 선언
jstl문법을 사용하고싶을떄
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<a href="/write">글쓰기</a>
	<div>글 리스트가 보일 부분</div>
	<!-- var = "키값" pageContext에서 바뀜 -->
	<%-- 
	<c:forEach var="i" begin="0" end="10" step="1">
		<div>${i}</div>
	</c:forEach>
	--%>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
		</tr>
		
		<c:forEach var="item" items="${list}" varStatus="status">
		<tr>
			<td>${status.index}</td>
			
			<td><a href="/detail?no=${status.index}">${item.title}</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>