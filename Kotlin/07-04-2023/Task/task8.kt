// Write a Java program to compare two array lists.
fun main()
{
    var a= arrayListOf<String>()
    a.add("Rutvik")
    a.add("Manan")
    for(i in a)
    {
        println(i)
    }
    var b= arrayListOf<String>()
    b.add("Manan")
    b.add("Rutvik")
    for(i in b)
    {
        println(i)
    }
    var compare= arrayListOf<String>()

    compare.addAll(a)
    compare.addAll(b)

    println("Compare:$compare")
}