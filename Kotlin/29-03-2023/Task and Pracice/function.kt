//With para with return type
fun add(a:Int,b:Int) :Int
{
    return a+b
}
//With Para Without Return type
fun add2(a:Int,b:Int)
{
    var c=a+b
    println(c)
}
//With Return type Without Para
fun add3():Int
{
    var a=5
    var b=6
    var c=a+b
    return c
}
//Without Para Without Return type
fun add4()
{
    var a=5
    var b=6
    var c=a+b
    println(c)
}
fun main()
{
    println(add(6,5))
    add2(6,5)
    println(add3())
    add4()
}