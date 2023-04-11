import java.util.*
import kotlin.collections.HashSet

fun main()
{
    var a=HashSet<String>()
    a.add("A")
    a.add("B")
    a.add("C")
    for(i in a)
    {
        println(i)
    }
    var array= arrayOfNulls<String>(a.size)
    a.toArray(array)
    println("Array:${Arrays.toString(array)}")
}