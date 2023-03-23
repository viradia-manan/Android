fun main()
{
    println("Enter a first number")
    var num1 = readLine()!!.toInt()

    println("Enter a second number")
    var num2 = readLine()!!.toInt()

    println("Enter a third number")
    var num3 = readLine()!!.toInt()

    if(num1<num2) {
        if(num3>num2)
        {
            println("$num3 is max")
        }
        else
        {
            println("$num2 is max")
        }
    }
    else
    {
        println("$num1 is max")
    }

}