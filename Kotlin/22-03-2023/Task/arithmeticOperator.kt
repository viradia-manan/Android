fun main() {
    println("Enter the first number")
    var num1 = readLine()!!.toInt()

    println("Enter the second number")
    var num2 = readLine()!!.toInt()

    println("Enter the operator")
    var operator = readLine()

    var sum = num1+num2
    var sub = num1-num2
    var multi = num1*num2
    var div = num1/num2

    when(operator)
    {
        '+'->
        {
            println("Sum is: $sum")
        }
        '-'->
        {
            println("Substartion is: $sub")
        }
        '*'->
        {
            println("Multiplition is: $multi")
        }
        '/'->
        {
            println("Division is: $div")
        }
    }


}