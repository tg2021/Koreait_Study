<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<input type= "text" id = "num1">
		<input type= "text" id = "num2">
		<button onclick="sum()">더하기</button>
		<button onclick="minus()">빼기</button>
		<!-- 이것을 클릭하면 sum()메소드를 호출하라 -->
	</div>
	<div>
		<input type= "text" id = "result">
	</div>
	<script>
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2');
		// querySelector('#num2') 이객체의 주솟값을 불러옴
		var resultElem = document.querySelector('#result');
		function sum() {
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			
			resultElem.value = parseInt(num1) + Number(num2);
				
		}
		function minus() {
			/* 
			이것도 가능하지만 불안정
			var num1 = num1.value;
			var num2 = num2.value;
			*/
			var num1 = num1Elem.value;
			var num2 = num2Elem.value;
			
			resultElem.value = parseInt(num1) - parseInt(num2);
		}
	</script>
</body>
</html>