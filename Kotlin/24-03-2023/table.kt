fun main()
{
    println("Enter the number")
    var num = readLine()!!.toInt()

    for (i in 1..10)
    {
        val multiply = num * i
        println("$num * $i = $multiply")
    }
}