open class cricketer
{
    fun input(t:Int, b:Int)
    {
        println("$t,$b")

    }
}
class batsman:cricketer()
{
    fun b_input(a:Float)
    {
        println("$a")
    }
}
fun main()
{
    println("Enter Total Runs of the Batsman:")
    var t= readLine()!!.toInt()

    println("Enter Best performance of the batsman:")
    var b=readLine()!!.toInt()

    println("Average runs:$t/$b")

    var b1=batsman()

    println(b1.input(10000,183))


}