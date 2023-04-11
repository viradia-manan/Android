fun main()
{
    var list = mutableListOf<String>("A","B","C","D")

    list.add("E")

    for(i in list)
    {
        println(i)
    }
}