fun reverse(str:String): String {
    if(str.isEmpty())
    {
        return str
    }

    return reverse(str.substring(1))+str[0]
}


fun main()
{
    var name = "Manan"
    var rev = reverse(name)
    println(rev)
}