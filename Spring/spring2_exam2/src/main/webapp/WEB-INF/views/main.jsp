<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>안녕</title>
    <meta charset="UTF-8">
</head>
<body>
<div>
    <div>
        <form method="post" action="/result">
            연도 :
            <select name="deal_year">
                <c:forEach begin="2000" end="2020" var="year">
                    <option value="${year}">${year}년</option>
                </c:forEach>
            </select>

            월 :
            <select name="deal_month">
                <c:forEach begin="1" end="12" var="month">
                    <option value="${month}">${month}월</option>
                </c:forEach>
            </select>

            지역 : 대구시
            <select name="ex_cd">
                <c:forEach items="${requestScope.locationList}" var="item">
                    <option value="${item.ex_cd}">${item.local_nm}</option>
                </c:forEach>
            </select>
            <input type="submit" value="검색">
        </form>
    </div>
</div>
</body>
</html>
