// Write a Java program to print all the elements of a ArrayList using the position of the elements.
fun main()
{
    var a= arrayListOf<String>()
    a.add("Manan")
    a.add("Dhaval")
    a.add("Bhavin")
    a.add("Jayraj")
    println("Original ArrayList:"+a)
    println("Position of the Element:")
    var b=a.size
    for(i in a)
    {
        println(i)
    }

}