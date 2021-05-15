// javascript에서는 0만 true
if (1) {
  console.log("1은 true다");
}

if (0) {
  console.log("1은 true다");
} else {
  console.log("0은 false다");
}

if (-2) {
  console.log("-2는 true다");
}
if ("") {
  console.log("''는 true");
} else {
  console.log('"는 false"');
}
if ("a") {
  console.log("'a는 true'");
}

// boolean =  true
// 숫자 0은 false, 나머지 true
// 문자열 빈칸은 false, 나머지 true
// 객체, 배열 true
// undefined, null은 false

// undefined는 값이 할당됝적이 없다
// null은 주소값이 없다

var num;
console.log(num);

num = null;
console.log(num);
// var result1 = 10 > 5;
// console.log(result1);
