fun main()
{
    println("Enter the number")
    var num = readLine()!!.toInt()

    var reversed = 0

    while (num!=0)
    {
        var digit = num % 10
        reversed = reversed * 10 + digit
        num/=10
    }
    println("Reversed Number $reversed")
}