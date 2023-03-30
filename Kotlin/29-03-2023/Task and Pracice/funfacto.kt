fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n*factorial(n-1)
}

fun main()
{
    val number = 5
    val result: Long

    result = factorial(number)
    println("Factorial of $number = $result")
}