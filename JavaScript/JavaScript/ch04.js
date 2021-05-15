//NaN : not a Number
var val_1 = "10";
var val_2 = 5;

// 더하기를 제외한 모든 연산처리가능
console.log(val_1 + val_2);
console.log(val_1 * val_2);
console.log(val_1 / val_2);
console.log(val_1 - val_2);
console.log(val_1 % val_2);

// 문자열 변수와 숫자형 변수 더하기 사용을 위한 형변환
console.log(parseInt(val_1) + val_2);
console.log(Number(val_1) + val_2);

console.log("---------------");
var val_3 = 7;
var val_4 = 9;

// 문자형으로 변환
console.log(val_3 + val_4);
console.log("" + val_3 + val_4);
console.log(String(val_3) + val_4);
