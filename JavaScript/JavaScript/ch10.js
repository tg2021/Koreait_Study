var arr = [1, 2, 3, 4, 5, 6, 7, 8];

arr.length = 3;
console.log("len : " + arr.length);
arr[3] = 10;
console.log("len : " + arr.length);
for (var i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

console.log("-------------");
function print(item) {
  console.log("item : " + item);
}

//리턴되는게 없음

var result = arr.forEach(print);
console.log(result);
