fun main()
{
    var maxnum = 0

    println("Enter the number")
    var num = readLine()!!.toInt()

    while (num>0)
    {
        var temp = num%10

        if(temp > maxnum)
        {
            maxnum = temp
        }
        num = num/10
    }

    println("Maxnum is: $maxnum")
}