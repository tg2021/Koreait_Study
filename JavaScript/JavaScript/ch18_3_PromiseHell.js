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

// await, async
async function run() {
  await foo();
  await bar();
  await baz();
}
run();
