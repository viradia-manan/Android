open class parents
{
    fun p()
    {
        println("This is a parent class")
    }
}

open class child
{
    fun c()
    {
        println("This is a child class")
    }
}

class method1 : parents()
{
    fun p1()
    {
        println("This is a parent class")
    }
}

class method2 : child()
{
    fun c1()
    {
        println("This is a parent class")
    }
}

class method3 :child()
{
    fun c2()
    {
        println("This is perent to child class")
    }
}


fun main()
{
    var m1 = method1()
    var m2 = method2()
    var m3 = method3()

    m1.p1()
    m2.c1()
    m3.c2()
}