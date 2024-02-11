//in js, if a string has a format as a number
//it's ok to do - , * , /
//but it's gonna wrong to do +, for string , + is for concat
//if you want to use math +, you need to convert them into number
function minus(){
    //1.get the text from the first box
    var box = document.getElementById("num1");
    var value1 = box.value;

    //2.get the text from the second box
    var value2 = document.getElementById("num2").value;
    // alert(value2)

    //3.do the caculation
    var result = value1 - value2;
    // alert(result)

    //4.set up the result for the third box
    document.getElementById("result").value = result;
}

function plus(){
    //1.get the text from the first box
    var box = document.getElementById("num1");
    var value1 = parseInt(box.value);

    //2.get the text from the second box
    var value2 = parseInt(document.getElementById("num2").value);
    // alert(value2)

    //3.do the caculation
    var result = value1 + value2;
    // alert(result)

    //4.set up the result for the third box
    document.getElementById("result").value = result;
}