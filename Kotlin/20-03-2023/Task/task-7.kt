fun main()
{
    println("Enter Your Gujarati Marks")
    var gujarati = readLine()!!.toInt()

    println("Enter Your Hindi Marks")
    var hindi = readLine()!!.toInt()

    println("Enter Your Maths Marks")
    var maths = readLine()!!.toInt()
    
    println("Enter Your Social Science Marks")
    var social_science = readLine()!!.toInt()

    println("Enter your Sanskrit Marks")
    var sanskrit = readLine()!!.toInt()

    var total = gujarati+hindi+maths+social_science+sanskrit

    println("Total Marks is: $total")

    var per = total/5

    println("Percentage is: $per")
}