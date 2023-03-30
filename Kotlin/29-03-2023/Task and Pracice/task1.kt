fun main()
{
    println("Enter the Name")
    var string = readLine()

    for (i in 0..string!!.length)
    {
        var copy = string!![i]
        println(copy)
    }
}