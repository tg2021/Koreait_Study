<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<link href="/res/css/boardList.css" rel="stylesheet">
<link rel="stylesheet" 
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden { display: none; }
	.fa-heart{ color: red; }
</style>
<script defer="defer" src="/res/js/BoardDetail.js"></script>
</head>
<body>
	<h1>디테일 페이지</h1>
	<div><a href="list">리스트로 돌아가기</a></div>
	<div>${param.iboard}</div>
	
	<div>글번호 : ${data.iboard}</div>
	<div>제목 : ${data.title}
		<c:if test="${data.isFav eq 0}">
			<a href="fav?iboard=${param.iboard }&fav=1"><i class="far fa-heart"></i></a> 
		</c:if>
		<c:if test="${data.isFav eq 1}">
			<a href="fav?iboard=${param.iboard }&fav=0"><i class="fas fa-heart"></i></a>
		</c:if>
	</div>
	<div>작성자 : ${data.unm} | 작성일시 : ${data.regdt}</div>
	<div>${data.ctnt}</div>
	
	<c:if test="${loginUser.iuser == data.iuser}">
		<div>
			<a href="del?iboard=${param.iboard }">삭제</a>
			<a href="mod?iboard=${param.iboard }">수정</a>
		</div>
	</c:if>
	
	<h3>댓글</h3>
	<!-- 등록때 쓰는 form -->
	<div>
		<form id="insFrm" action="cmt" method="post">
			<!-- 
				value에 0은 등록버튼과 수정삭제버튼을 hidden처리한다
				0일때 등록버튼이 나오고 0이 아닐때 수정버튼이 나온다
			 -->
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
			</div>
			<div>
				<input type="submit" value="댓글작성">			
			</div>
		</form>
	</div>
	<!-- 수정할때 쓰는 form -->
	<div>
		<form id="updFrm" action="cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
			</div>
			<div>
				<input type="submit" value="댓글수정">
				<input type="submit" value="댓글취소" onclick="showInsFrm();">
			</div>			
		</form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
			<!-- 
				4가지 Scope
				pageContext : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
				request : 웹 브라우저 별로 변수가 관리되는 경우 사용
               			  해당 객체가 생성되서 소멸될 때까지 계속 사용 가능 
				session : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용
				aplication : 페이지 내에서 지역변수처럼 사용
				
				Scope사용이유
				pageContext, request, session, aplication 순으로 검사를 하는데 Scope를 쓰면 바로 그 구간을 검사하여 속도를 향상시키는데 
				사람이 느낄정도의 큰 차이는 없다
			 -->
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<!-- 
						글을 작성한 사용자만 수정,삭제가 가능하게한다 
					 -->
					<td>
						<c:if test="${sessionScope.loginUser.iuser == requestScope.data.iuser}">
								
								<button onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">수정</button>
								<!-- 
									trim() : 앞뒤 빈공간을 지워준다
								 -->
								<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt});">삭제</button>
								<!-- ${requestScope.data.iboard}는 삭제를 위함이 아닌 삭제 후 주소로 되돌아 가기위함 -->
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>