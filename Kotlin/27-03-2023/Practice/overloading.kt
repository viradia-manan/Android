class overloading
{
    fun cal(a:Int,b:Int):Int // method 1
    {
        return a+b
    }

    fun cal(a:Int,b:Int,c:Int):Int //method 2
    {
        return  a*b*c
    }
}

fun main()
{
    var o1 = overloading()

    //call method
    println(o1.cal(2,3))//5
    println(o1.cal(2,3,2))
}