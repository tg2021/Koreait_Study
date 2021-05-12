<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, tr, td {
		border: 1px solid black;
		border-collapse: collapse; 
	}
	.record {cursor: pointer;}
	.record:hover {background-color: #ecf0f1;}
</style>
</head>
<body>
	<div>
		<a href="/write3">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<td>no</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:forEach items= "${list}" var="item">
			<!-- 
			a태그를 사용할 경우 td태그의 값을 모두 a태그로 감싸야한다  
			a태그를 사용할 경우
			<td>
				<a>값</a>
			</td>
			효율적인 코드가 아님
			-->
				<tr class = "record" onclick="moveToDetail(${item.iboard});">
					<td>${item.iboard}</td> 
					<td>${item.title}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function moveToDetail(iboard) {
			
			//consol.log('iboad : %d', iboard);
			location.href = '/detail3?iboard=' + iboard;
		}
		
	</script>
</body>
</html>