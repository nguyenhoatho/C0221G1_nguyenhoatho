function isFibonacci(n: number): number {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return isFibonacci(n - 1) + isFibonacci(n - 2);
    }
}
let sum = 0;
let arr=new Array();
for (let i=0;i<=10;i++){
    sum+=isFibonacci(i);
    arr.push(isFibonacci(i))
}
console.log("Mãng fibonacci: "+arr);
console.log("Tổng các số fibonacci trong mảng trên là: " + sum);


// let array=[1,2,3,4,5,6];
// for (let i=0;i<array.length;i++){
//    let j=0;
//    while (array[i]>=isFibonacci(j)){
//        if (array[i]==isFibonacci(j)){
//            sum+=array[i]
//            break
//        }
//        j++
//    }
// }
// console.log("Mãng fibonacci: "+array);
// console.log("Tổng các số fibonacci trong mảng trên là: " +sum);
