fun main()
{
    var a= arrayListOf<String>()
    a.add("Java")
    a.add("Python")
    a.add("Kotlin")
    a.add("C++")
    println("...............................")
    for(i in a)
    {
        println(i)
    }
    println("Size of the a="+a.size)
    val b= ArrayList<Int>(5)
    b.add(1)
    b.add(2)
    b.add(3)
    println("............................................")
    for(i in b)
    {
        println(i)
    }
    println("Size of B="+b.size)


}