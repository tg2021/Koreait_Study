var arr2 = [10, 20, 30, 40, 50, 60];
var result = arr2.map(function (item) {
  if (item >= 30) {
    return item * 2;
  }
  return item;
});
