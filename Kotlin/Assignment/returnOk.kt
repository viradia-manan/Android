class msg
{
    fun send(message:String)
    {
        println("Sending "+message)
        Thread.sleep(1000)
        println("Return "+message)
    }
}

class msgsender(var message: String,var msg_sender:msg):Thread()
{
    override fun run()
    {
        synchronized(msg_sender)
        {
            msg_sender.send(message)
        }
    }
}

fun main()
{
    var msg = msg()
    var message = msgsender("Manan",msg)
    message.start()
}