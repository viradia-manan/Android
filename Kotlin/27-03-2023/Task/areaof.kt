class area
{
    // area od rectangle
    fun a(w:Int, l:Int) : Int
    {
         return w*l
    }

    // area of square
    fun a(w:Double, l: Double) : Double
    {
        return w*l
    }
}

fun main()
{
    var r = area()

    println(r.a(2,5))//10
    println(r.a(2.00,2.00))//4
}