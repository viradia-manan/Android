fun main()
{
    for (i in 1..5)
    {
        for (k in i..(5-1))
        {
            print(" ")
        }

        for (j in i downTo 1)
        {
            print(j)
        }
        println()
    }
}