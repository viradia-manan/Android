//  Write a Java program to replace the second element of a ArrayList with the specified element.
fun main()
{
    var a= arrayListOf<String>()
    a.add("Java")
    a.add("Python")
    a.add("C Programming")
    a.add("C++")
    a.add("Kotlin")

    for(i in a)
    {
        println(i)
        a.set(2,"Python")
    }


}