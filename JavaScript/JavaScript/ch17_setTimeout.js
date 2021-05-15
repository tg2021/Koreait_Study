// 출력시간을 줌
// 빠른거 먼저 출력
/*
멀티프로세싱 : 창을 여러개 띄움
멀티쓰레싱의 예 : 게임
(내 캐릭터가 움직이면서 상대방도 움직임)
3Ghz : 1초에 3억번 박수칠 수 있는 속도

CPU
(cache)

RAM

SSD
HDD
*/
var val;
setTimeout(function () {
  console.log("안녕~~");
  val = 100;
  console.log("val : " + val);
}, 3000);

// 아래에 두면 속도가 너무 느려 undefined가 출력
// setTimeout 안에 있어야 출력가능
// console.log("val : " + val);

setTimeout(function () {
  console.log("Hello");
}, 1000);
