class thread1
{
    fun run()
    {
        for (i in 1..10)
        {
            println("Thread1 is: "+i)
        }
    }
}

class thread2
{
    fun run()
    {
        for (i in 1..10)
        {
            println("Thread2 is: "+i)
        }
    }
}

fun main()
{
    var t1 = thread1()
    var t2 = thread2()

    t1.run()
    t2.run()
}