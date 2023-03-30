fun max()
{
    println("Enter the num1")
    var num1 = readLine()!!.toInt()

    println("Enter the num2")
    var num2 = readLine()!!.toInt()

    if(num1<num2)
    {
        println("Number is $num2 big")
    }
    else
    {
        println("Number is $num1 big")
    }
}

fun main()
{
    max()
}