fun main()
{
    println("Enter 1st Student Percentage: ")
    var per1=readLine()!!.toInt()

    println("Enter 2nd Student percentage:")
    var per2=readLine()!!.toInt()

    println("Enter 3rd Student percentage:")
    var per3=readLine()!!.toInt()

    println("Enter 4th student percentage:")
    var per4=readLine()!!.toInt()

    println("Enter 5th student percentage:")
    var per5=readLine()!!.toInt()

    var per= arrayOf(per1,per2,per3,per4,per5)
    for(i in 0..4)
    {
        println(per[i])
    }
}