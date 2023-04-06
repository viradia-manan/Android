class a : Thread()
{
    override fun run()
    {
        for(i in 11..20)
        {
            println("Thread a: "+i)
        }
    }
}

class b :Thread()
{
    override fun run()
    {
        for(i in 11..20)
        {
            println("Thread b: "+i)
        }
    }
}

fun main()
{
    var A = a()
    var B = b()

    A.start()
    B.start()
}