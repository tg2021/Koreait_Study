var a = 10; // a : 10
console.log("a : " + a);

var b; // b : undefined
console.log("b : " + b);

console.log("d : " + d);
var d = 11;
/* 
d: undefined;
var를 어디에 적든 최상위로 올라감 -> hoisting
var 와 function만 hoisting 이 가능하다
선언부만 올라가고 값은 같이 올라가지 않는다
{
  안에 있는 느낌
}
*/

//console.log("c : " + c);

console.log("d : " + d);
