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

    for (x in 4 downTo 1)
    {
        for (z in (4-1) downTo x)
        {
            print(" ")
        }
        for (y in 1..x)
        {
            print(" *")
        }

        println()
    }
}