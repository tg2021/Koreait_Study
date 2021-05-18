<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link href="/res/css/boardList.css" rel="stylesheet">
<script defer="defer" src="/res/js/BoardList.js"></script>
</head>
<body>
	<h1>리스트</h1>
	<div>${loginUser.unm}님 (${sessionScope.loginUser.uid}) 환영합니다.</div>
	<div><a href="/user/logout">Logout</a></div>
	<div>
		<a href="write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<th>NO</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr >
			<c:forEach items="${list}" var="item">
				<tr class="record" class="cursor" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>	
				</tr> 			
			</c:forEach>
		</table>
	</div>
	
</html>