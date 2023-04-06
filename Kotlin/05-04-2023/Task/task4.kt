class TestThreadTwice1 :Thread()
{
    override fun run()
    {
        println("I am in run method")
    }
}

fun main()
{
   var t1 = TestThreadTwice1()

    t1.start()
    t1.start()
}