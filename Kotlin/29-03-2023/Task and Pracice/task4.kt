fun main()
{
    println("Enter the Number")
    var num = readLine()!!.toInt()

    var square = num*num

    println("Square is: $square")

    var cube = square*square

    println("Cube is: $cube")
}