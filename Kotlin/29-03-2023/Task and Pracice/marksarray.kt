fun main()
{
    var marks = 0
    for(i in 1..3)
    {

        println("Enter Your Marks $i")
        marks = readLine()!!.toInt()

        marks+=5
        //Total


    }
    println(marks)


}