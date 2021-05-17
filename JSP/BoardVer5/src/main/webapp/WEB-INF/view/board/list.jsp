<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
	.cursor {
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>리스트</h1>
	<div>${loginUser.unm}님 (${loginUser.uid}) 환영합니다.</div>
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
				<tr class="cursor" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>	
				</tr> 			
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			location.href = "/board/detail?iboard=" + iboard;
		}
	</script>
</body>
</html>