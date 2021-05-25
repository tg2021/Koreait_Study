<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<div><a href="#" onclick="goBack();">돌아가기</a></div>
<h2>${requestScope.result.title}</h2>
<div>글번호 : ${requestScope.result.iboard}</div>
<div>작성자 : <c:out value="${requestScope.result.writerNm}"></c:out> | 작성일시 : ${requestScope.result.regdt}</div>
<div><c:out value="${requestScope.result.ctnt}"></c:out></div>


<div>
	<form id="cmtFrm" data-iboard="${param.iboard}">
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</div>
<div id="cmtList"></div>

<script src="/res/js/boardDetail.js"></script>