// 콜백함수
var arr = {
  0: 10,
  1: 20,
  2: 30,
  3: 40,
  length: 4,
  forEach: function (f) {
    for (var i = 0; i < this.length; i++) {
      f(this[i]);
    }
  },
};

function print(item) {
  console.log("item : " + item);
}
arr.forEach(print);
