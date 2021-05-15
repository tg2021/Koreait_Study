var obj = {
  // = 이 아닌 :
  name: "홍길동",
  age: 30,
  run: function () {
    console.log("%s이(가) 달린다.", this.name);
  },
};
console.log(obj);
obj.name = "하니";
obj.run();

// 타입이 정수형으로 바뀜
obj.run = 10;
console.log("run : " + obj.run);

var sum = function (n1, n2) {
  return n1 + n2;
};
function sum2(n1, n2) {
  return n1 + n2;
}
console.log(sum(10, 20));
console.log(sum2(10, 20));
