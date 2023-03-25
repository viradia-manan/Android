fun main()
{
    var input = 10

    var result: Long  = 1

    for (i in 1..input)
    {
        result *= i.toLong()

        println("The factorial of $input is $result")
    }
}



