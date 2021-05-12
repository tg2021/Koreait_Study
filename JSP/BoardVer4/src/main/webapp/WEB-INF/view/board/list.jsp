<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, th, tr, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>리스트</h1>	
	<div>로그인 성공</div>
	<div>${loginUser.unm}님 (${loginUser.uid}) 환영합니다. </div>
	<div><a href="/user/logout">Logout</a></div>
	
	<div>
		<a href="write"><button>글쓰기</button></a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list}" var="item"> 
				
			<!--
			 items=" " : Collection 객체
			 items=" " 에 어레이리스트 등이 들어갈 수 있다 
			 var=" " : 사용할 변수명
			 <%-- 
			 	var=" " = pageContext.setAttribute
			 --%>
			 -->
				<tr onclick="moveTODetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveTODetail(iboard) {
			location.href = "/board/detail?iboard=" + iboard;
		}
	</script>
</body>
</html>