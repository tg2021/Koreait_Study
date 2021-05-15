var pro1 = new Promise(function (resolve) {
  setTimeout(function () {
    console.log(1);
    resolve(2);
  }, 3000);
});

var pro2 = new Promise(function (resolve) {
  setTimeout(function () {
    resolve(3);
  }, 2000);
});

pro1.then(function (res) {
  console.log("2 : " + res);

  pro2.then(function (res) {
    console.log("3 : " + res);
  });
});
