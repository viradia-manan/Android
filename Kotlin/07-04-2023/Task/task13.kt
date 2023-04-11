// Write a Java program to get a collection view of the values contained in this map.

fun main()
{
    var a= mapOf<String,Int>("One" to 1,"Two" to 2,"Three" to 3,"Four" to 4 )
    var b= mutableMapOf<String,Int>("One" to 1,"Two" to 2,"Three" to 3,"Four" to 4)



    println(a.keys)
    println(a.values)
    println(b)


}