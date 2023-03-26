fun main()
{
    var k = 5
    for(i in 1..k)
    {
        for(j in 1..i)
        {
            if(j % 2 == 1)
            {
                print(1)
            }
            else
            {
                print(0)
            }
        }

        println()
    }
}