fun main()
{
    for (i in 5 downTo 1)
    {
        for (k in (5-1) downTo i)
        {
            print(" ")
        }
        for (j in 1..i)
        {
            print("* ")
        }

        println()
    }
}