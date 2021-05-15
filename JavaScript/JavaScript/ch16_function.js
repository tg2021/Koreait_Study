function sum(n1) {
  if (n1 == undefined) {
    n1 = 10;
  }
  console.log(n1 + n2);
}
sum(10, 30);

// sum에 값이 없으면 n1 = 10을 출력
function sum(n1 = 10) {
  console.log(n1 + n2);
}

function sum(n1 = 10, n2) {
  console.log(n1);
  console.log(n2);
}
// 가변인자 int... 과 같음
/*
arguments란 어떤 함수로 전달되는 인자들의 값을
가지고 있는 배열과 유사한 형태의 객체로 
그 함수의 내부에서 접근할 수 있다.
*/
function sumAll() {
  var sum = 0;
  for (var i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  console.log('sum' + sum);
}

function sumAll2() {
  var sum = 0;
  for (var i = 0; i < args.length; i++) {
    sum += args[i];
  }
  console.log('sum2' + sum2);
}

sum(123);
sum(20, 30);
console.log("-------------");
sumAll(1); // 1
sumAll(1, 5); // 6
sumAll(1, 2, 7); // 13
sumAll(1, 5, 7, 10); // 23
console.log("-------------");
sumAll2(1); // 1
sumAll2(1, 5); // 6
sumAll2(1, 2, 7); // 13
sumAll2(1, 5, 7, 10); // 23

function sumAll2(...args)

/*
나중에 한번 보기 (airbnb)
https://github.com/airbnb/
javascript/blob/master/README.md#functions

https://developer.mozilla.org/ko/
docs/Web/JavaScript/Reference/Functions/arguments
*/