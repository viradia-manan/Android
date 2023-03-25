fun main()
{
    println("Enter the number")
    var input = readLine()!!.toInt()

    var temp1 = 0
    var temp2 = 1

    println("The number is defined as: $input")
    println("The Fibonacci series till $input terms:")

    for (i in 1..input)
    {
        print("$temp1 ")

        var sum = temp1 + temp2
        temp1 = temp2
        temp2 = sum
    }
}