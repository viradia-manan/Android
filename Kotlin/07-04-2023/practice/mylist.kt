

fun main()
{
    var list = ArrayList<String>()
    list.add("Android")
    list.add("Java")
    list.add("Php")
    list.add("Flutter")



    var list2 = ArrayList<String>()

    list2.add("ST")
    list2.add("GD")
    list2.add("WD")
    list2.add("Android")



    list.retainAll(list2)

    for(i in list)
    {
        println(i)
    }

}