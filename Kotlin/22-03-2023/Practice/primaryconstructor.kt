class primaryconstructor(var id:Int, var name:String, var surname:String, var email:String)
{
    fun display()
    {
        println("$id,$name,$surname,$email")
    }
}

fun main()
{
    var t = primaryconstructor(101,"Prakruti","Vyas","prakruti@gmail.com")
    var t1 = primaryconstructor(102,"rutvik","xyz","rutvik@gmail.com")
    var t3 = primaryconstructor(103,"manan","xyz","manan@gmail.com")

    t.display()
    t1.display()
    t3.display()
}