fun main()
{
    for (i in 1..5)
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