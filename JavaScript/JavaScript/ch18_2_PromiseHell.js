function foo() {
  return new Promise(function (resolve) {
    setTimeout(function () {
      console.log("foo ok");
      resolve();
    }, 3000);
  });
}

function bar() {
  return new Promise(function (resolve) {
    setTimeout(function () {
      console.log("bar ok");
      resolve();
    }, 2000);
  });
}

function baz() {
  return new Promise(function (resolve) {
    setTimeout(function () {
      console.log("bazzz ok");
      resolve();
    }, 1000);
  });
}
/*
foo().then(function () {
  bar().then(function () {
    baz().then(function () {

    });
  });
});
*/

foo()
  .then(function () {
    return bar();
  })
  .then(function () {
    return baz();
  })
  .then(function () {
    // promise지옥에 빠지지 않고 사용하는 방법
  });
