<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<head>
    <meta charset="UTF-8">
    <title>${requestScope.boardDomain.title}</title>
    <link rel="stylesheet" href="/res/css/boardDetail.css">
    <script defer src="/res/js/boardDetail.js"></script>
</head>
<body>
    <link rel="stylesheet" href="/res/css/boardDetail.css">
    <div><a href="#" onclick="goBack();">돌아가기</a></div>
    <h2>${requestScope.data.title}</h2>
    <div>글번호 : ${requestScope.data.iboard}</div>
    <div>작성자 : <c:out value="${requestScope.data.writerNm}"></c:out> | 작성일시 : ${requestScope.data.regdt}</div>
    <div><c:out value="${requestScope.data.ctnt}"></c:out></div>

    <c:if test="${not empty sessionScope.loginUser}">
        <div>
            <form id="cmtFrm" onsubmit="return false;">
                <input type="text" id="cmt" placeholder="댓글">
                <input type="button" value="댓글달기" onclick="regCmt();">
            </form>
        </div>
    </c:if>
    <div id="cmtList" data-login-user-pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>

</body>

<script src="/res/js/boardDetail.js"></script>