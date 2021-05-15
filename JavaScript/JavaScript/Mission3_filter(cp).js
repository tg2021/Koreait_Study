var arr = {
  0: 1,
  1: 2,
  2: 3,
  3: 4,
  4: 5,
  5: 6,
  6: 7,
  7: 8,
  length: 8,
  filter: function (fn) {
    var temp = [];
    for (var i = 0; i < this.length; i++) {
      if (fn(this[i])) {
        temp.push(this[i]);
      }
    }
    return temp;
  },
};

var result = arr.filter(function (item) {
  return item % 2;
});

console.log(arr);
console.log(result);
