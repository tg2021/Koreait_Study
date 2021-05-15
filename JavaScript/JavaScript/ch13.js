var arr = [];
arr.push(10);
arr.push(20);
arr.push(30);
arr.push(40);

/*
      순차적으로 앞의 값을 자름
      arr.shift();
      arr.shift();
      */
/*
        shift : 앞의 값 삭제
        pop : 뒤의 값 삭제
        unshift : 앞에 값 추가
        push : 뒤에 값 추가
        splice : 중간 값 삭제
      */
// arr.length = arr.length - 1;
// arr.length = arr.length - 1;
// console.log(arr);

// arr.pop();
// console.log(arr);
arr.unshift(11);
arr.unshift(12);
console.log(arr);

console.log("arr : " + arr);
var delVal = arr.splice(2, 2);

console.log("arr : " + arr);
console.log("delVal : " + delVal);
