class num1 :Runnable
{
    override fun run()
    {
        for(i in 50..60)
        {
            println("Thread num1: "+i)
        }
    }
}

class num2 :Runnable
{
    override fun run()
    {
        for(i in 50..60)
        {
            println("Thread num2: "+i)
        }
    }
}

fun main()
{
    var n1 = Thread(num1())
    var n2 = Thread(num2())

    n1.start()
    n2.start()
}