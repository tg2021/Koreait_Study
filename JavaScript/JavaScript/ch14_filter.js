var arr = [1, 2, 3, 4, 5, 6, 7, 8];

var result = arr.filter(function (item) {
  // 홀수는 담구요 짝수는 안 담게
  // if (item % 2 == 0) {
  //   return false;
  // }
  // return true;

  return item % 2;

  console.log("item : " + item);
});

// true는 값을 담고,
// false를 하면 값이 담기지 않음

console.log("arr : " + arr);
console.log("result : " + result);
console.log("result.length : " + result.length);

/*
forEach,
map, -> 방의 크기가 같아야함
(값을 수정할때 사용)
filter -> 방의 크기가 달라도된다 
(배열의 값을 넣을지 결정)
값을 넣어줌

*/
