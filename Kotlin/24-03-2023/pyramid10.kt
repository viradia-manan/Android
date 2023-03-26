fun main()
{
    var k = 1

    for(i in 1..5)
    {
        for(j in 1..i)
        {
            print(k)
            k += 1
        }
        println()
    }
}