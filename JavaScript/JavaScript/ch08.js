function calc(cal, n1, n2) {
  return cal(n1, n2);
  /*
        calc(sum, 10, 20)의 cal은 sum, n1는 10, n2는 20
        으로 변환
        */
}

// 참조할 수 있는 주소값을 calc로보냄
function sum(num1, num2) {
  return num1 + num2;
}

function minus(num1, num2) {
  return num1 - num2;
}

function multi(a, b) {
  // console.log(a * b);
  return a * b;
}
var result = calc(multi, 2, 3);
console.log("result : " + result);
/*
      var result = calc(sum, 10, 20);
      console.log("result = %d", calc(sum, 10, 20));
      console.log("result = %d", calc(minus, 40, 20));

      var methodSum = sum;
      console.log("result = %d", methodSum(1, 2));

      var methodSum = minus;
      console.log("result = %d", methodSum(10, 2));
      */
