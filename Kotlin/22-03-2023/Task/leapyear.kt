fun main()
{
    println("Enter Year")
    var year = readLine()!!.toInt()

    if(year%4==0)
    {
        println("$year is Leap Year")
    }
    else
    {
        println("$year is not Leap Year")
    }
}