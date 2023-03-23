fun main()
{
    println("Enter Your Maths Marks")
    var maths = readLine()!!.toInt()

    println("Enter Your Gujarati Marks")
    var gujarati = readLine()!!.toInt()

    println("Enter Your Science Marks")
    var science = readLine()!!.toInt()

    println("Enter Your English Marks")
    var english = readLine()!!.toInt()

    println("Enter Your Hindi Marks")
    var hindi = readLine()!!.toInt()

    var total = maths+gujarati+science+english+hindi

    var per = total/5

    if(per>=75)
    {
        println("Distinction")
    }
    else if(per>=60)
    {
        println("First Class")
    }
    else if(per>=50)
    {
        println("Second Class")
    }
    else if(per>=35)
    {
        println("Pass Class")
    }
    else
    {
        println("Fail")
    }
}