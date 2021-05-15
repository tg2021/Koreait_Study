var arr = [10, 20, 30, 40, 50, 60];
var arr2 = {
  0: 10,
  1: 20,
  2: 30,
  3: 40,
  4: 50,
  5: 60,
  length: 6,
  map: function (callback) {
    var temp = [];
    for (var i = 0; i < this.length; i++) {
      var val = callback(this[i]);
      // temp.push(val);
      temp[i] = val;
    }
    return temp;
  },
};

var result = arr.map(function (item) {
  return item - 2;
});
var fn = function (item) {
  return item - 2;
};
var result2 = arr.map(fn);
console.log("result : " + result);
console.log("result2 : " + result2);
