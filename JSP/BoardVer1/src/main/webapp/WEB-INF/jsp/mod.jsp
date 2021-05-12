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
<title>Insert title here</title>
</head>
<body>
	<h1>글수정</h1>
	<form action="/mod" method="post">
	<!-- method에 적을 수 있는건 get post만 가능 -->
		<input type="hidden" name="no" value="<%=no%>">
		<div>
			제목 : <input type="text" name="title" value="<%=vo.getTitle() %>"> <!-- name이 키값 -->
		</div>
		<div>
			내용 : <textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글수정"> 
			<input type="reset" value="초기화" >
			<input type="button" value="뒤로가기" onclick="script:history.back();">
		</div>
	</form>
</body>
</html>


<!-- 
	/mod?no=1
	mod.jsp파일이 응답해야되구요
	
	제목
	내용에 기존값이 나타나야합니다.
	
	BoardModSerlet생성
 -->