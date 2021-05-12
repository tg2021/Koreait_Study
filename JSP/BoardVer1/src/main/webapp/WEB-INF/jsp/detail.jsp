<%@page import="com.koreait.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String no = request.getParameter("no"); 
	BoardVO vo = (BoardVO) request.getAttribute("data");
	// 형변환 할때 되도록 object사용
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<!--
	get 방식으로 서버한테 값을 전달할때는 쿼리스트링으로 전달
	post방식으로 서버한테 값 전달할때는 form 태그 사용하여 method
	post로 한 뒤 전달해야 함  
	-->

	<!-- 
	el식 : 
	 -->
	<h1>디테일 <%=no %></h1>
	<div><%=request.getParameter("no") %></div>

	<div>
		<form action="/del" method="post">		
			<input type="hidden" name="no" value="<%=no %>">
			<input type="submit" value="삭제">
		</form>
		<a href="/mod?no=<%=no %>"><button>수정</button></a>
		<!-- <a href="/del?no=<%=no %>"><button>삭제</button></a> -->
	</div>
	

	<div>제목 : <%=vo.getTitle() %></div>
	<div><%=vo.getCtnt() %> </div>
</body>
</html>

<!-- 
del 매핑되는 서블릿생성
doPost에서 no 파라미터 받으시고 해당되는 글(BoardVO객체 주소값)삭제해주시고

/list로 주소이동
 -->