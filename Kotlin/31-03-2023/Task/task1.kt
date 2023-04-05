fun rec(n:Int):Int
{
    var a = 0

    if(n==0)
    {
        return 0
    }
    a=(a*10)+(n%10)

    run{
        return rec(n / 10)
    }
}

fun main()
{
    println("Enter the number")
    var n = readLine()!!.toInt()

    var p =rec(n)

    if(p==n)
    {
        println("Not Palidrom")
    }
    else
    {
        println("Palidrom")
    }
}