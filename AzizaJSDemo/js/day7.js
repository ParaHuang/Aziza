//bind a click even on button
//1.load the content of this method when you load the page
function fun1(){
    alert("hello");
}

// var x = 10;
// console.log(typeof x);
// var functionName = function(){

// }
//1.only load the variable name when you load the page
//load the content of function when you call the function for the first time
var fun2 = function(){
    alert("define a function as define a variable");
}

document.getElementById("btn1").onclick = fun1;
document.getElementById("btn2").onclick = fun2;
document.getElementById("btn3").onclick = function(){
    alert("anonymous function");
};