import jdk.nashorn.internal.objects.NativeJava

open class rectangle
{
    fun area(l:Int,b:Int)
    {
        println(l*b)
    }

    fun perimeter(l:Int,b:Int)
    {
        println(2*(l+b))
    }

}

class square :rectangle()
{
    fun square(s:Int)
    {
        NativeJava._super(s,s);
    }
}

fun main()
{
    var r = rectangle()
    var s = square()

    println(r.area(2,3))
    println(r.perimeter(3,5))
    println(s.area(4, 4))
    println(s.perimeter(2,2))
}
