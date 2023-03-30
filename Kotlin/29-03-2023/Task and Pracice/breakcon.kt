fun main()
{
    for(i in 1..10)
    {
        if(i==5)
        {
            continue
        }
        println(i)
    }

    for(i in 1..10)
    {
        if(i==5)
        {
            break
        }
        println(i)
    }
}