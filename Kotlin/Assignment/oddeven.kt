fun main()
{
    println("Enter the number")
    var num = readLine()!!.toInt()

    if(num%2==0)
    {
        println("$num is Even")
    }
    else
    {
        println("$num is Odd")
    }
}