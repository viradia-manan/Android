class OverLoadingcalc {
    fun calc(a:Int,b:Int,c:Int):Int
    {
        println("Addition:")
        return a+b+c
    }
    fun calc(a:Int,b:Int,c:Int,d:Int,e:Int):Int
    {
        println("Substraction:")
        return a-b
    }
    fun calc(a:Int,b:Int,c:Int,d:Int):Int
    {
        println("Multiplication:")
        return a*b*c*d
    }
    fun calc(a:Double,b:Double):Double
    {
        println("Division:")
        return a/b
    }

}
fun main()
{
    var c1=OverLoadingcalc()
    var c2=OverLoadingcalc()
    var c3=OverLoadingcalc()
    var c4=OverLoadingcalc()

    println(c1.calc(15,17,89))
    println(c2.calc(100,25,25,25,5))
    println(c3.calc(15,5,3,2))
    println(c4.calc(15.00,6.00))}
