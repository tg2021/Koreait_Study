// 35 이하 값들은 -5
// 35 초과 값들은 +5
var arr2 = [10, 20, 30, 40, 50, 60];

var result3 = arr2.map(function (item) {
  if (item > 35) {
    return item + 5;
  }
  return item - 5;
});

// var result = arr2.map(function (item) {
//   return item * 2;
// });

function myMap(item) {
  return item - 2;
}

var result2 = arr2.map(myMap);

console.log("result3 : " + result3);
console.log("result : " + result);
console.log("arr2 : " + arr2);
console.log("result2 : " + result2);
