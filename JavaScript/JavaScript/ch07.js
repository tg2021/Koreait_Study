function sum(n1, n2) {
  return n1 + n2;
}

function sum2(n1, n2) {
  console.log("sum2 : %d", n1 + n2);

  return n1 + n2;
}
// // 자바스크립트는 앞에 값이 날아감

var result = sum(10, 20);
console.log("%s = %d", "result", result);

var ddd;
if ((ddd = sum(10, 20))) {
  console.log(ddd);
}

result = sum2(11, 22);
console.log(result);
console.log("%s = %d", "result", result);
