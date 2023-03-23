class student
{
    var id = 0
    var name = ""
    var mob = 0
}

fun main()
{
    var s1 = student()
    var s2 = student()
    var s3 = student()

    println("Enter Your Id")
    var id1 = readLine()!!.toInt()

    println("Enter Your Name")
    var name1 = readLine()

    s1.id= id1
    s1.name = name1.toString()

    println("Your id is ${s1.id} and Your name is ${s1.name}")
}