class send1
{
    fun send(msg:String)
    {
        println("Sending "+msg)

        Thread.sleep(2000)

        println(msg+" sent")
    }
}

class send2(var msg: String, var send1: send1):Thread()
{
    override fun run()
    {
        synchronized(send1)
        {
            send1.send(msg)
        }
    }
}

fun main()
{
    var send = send1()
    var s1 = send2("Hii", send)
    var s2 = send2("Byee",send)
    s1.start()
    s2.start()
}