/*
resolve : 잘 마무리됐을 때 사용
reject : 에러가 났을 때 사용

settimeout(인자1, 시간값) -> 한번만 호출
오래걸리는 작업에 사용
1000 = 1s
*/

// 오래걸리는 작업은 promise로 감싼다
// 통신은 무조건 느리기때문에 promise를 사용한다
// 무조건 new Promise()해서 promise 객체화
// var fn = function (resolve, reject) {
//   // 오래걸리는 작업!!!
//   // promise구조
//   if (작업이 잘 완료됐다면) {
//     resolve();
//   } else {
//     reject();
//   };
// };

//var prom = new Promise(fn);

var pro1 = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve(1); // resolve가 있어야 pro에서 40번에서 실행
  }, 2000);
});

var pro2 = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve(2);
  }, 3000);
});

// then catch o
// then1 catch then2 1번 then 과 2번 then은 다르다
// then2는 무조건 실행이 된다
pro1
  .then(function (res /*명칭 상관없음*/) {
    console.log("pro1 : " + res);
  })
  .catch(function (err) {
    console.log("err : " + err);
  })
  .then(function () {
    // 닫는거
    // stream (빨대 : 유튜브 재생할 때 필요한부분만
    // 다운받아 실행하는것(?))
  });

pro2.then(function (res) {
  console.log("pro2 : " + res);
});
