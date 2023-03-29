class overloadingex
{
    fun cal(a:Int,b:Int):Int // method 1
    {
        return a+b
    }

    fun cal(a:Double,b:Double):Double // method 2
    {
        return  a*b
    }
}

fun main()
{
    var o1 = overloadingex()

    //call method
    println(o1.cal(2,3))//5
    println(o1.cal(2.00,3.00))//6
}