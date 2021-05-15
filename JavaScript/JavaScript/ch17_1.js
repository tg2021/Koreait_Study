setTimeout(function () {
  console.log("1");
}, 5000);

setTimeout(function () {
  console.log("2");
}, 3000);

setTimeout(function () {
  console.log("3");
}, 1000);

console.log("-------------");

// 콜백지옥
setTimeout(function () {
  console.log("1");

  setTimeout(function () {
    console.log("2");

    setTimeout(function () {
      console.log("3");
    }, 1000);
  }, 3000);
}, 5000);
