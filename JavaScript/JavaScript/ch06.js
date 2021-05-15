var result = 10 && 12 && 17;
console.log(result);

result = 1 || 10 || 12;
console.log(result);

var a = "";
var b = "안녕";

var result2 = a || b;
console.log(result2);

for (var i = 2; i < 10; i++) {
  for (var j = 1; j < 10; j++) {
    console.log("%d * %d = %d", i, j, i * j);
  }
  console.log("\n");
}
