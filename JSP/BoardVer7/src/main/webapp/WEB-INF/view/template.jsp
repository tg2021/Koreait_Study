<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css">
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<c:if test="${empty sessionScope.loginUser}">
					<li><a href="/user/login">로그인</a></li>				
				</c:if>
				<c:if test="${not empty sessionScope.loginUser}">
					<li><a href="/user/logout">로그아웃</a></li>			
				</c:if>
				<li><a href="/board/list">리스트</a></li>
				<li><a href="/board/write">글쓰기</a></li>
				<li><a href="/board/favoriteList">좋아요</a></li>
			</ul>
		</nav>
	</header>
	<section>
		<!-- jsp파일을 가져와서 바꿔치기하면서 사용 곻용페이지 -->
		<jsp:include page="/WEB-INF/view/${requestScope.jsp}.jsp"></jsp:include>
	</section>
</body>
</html>