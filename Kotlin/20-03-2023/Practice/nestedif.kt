fun main()
{

    println("Enter Your Age")
    var age = readLine()!!.toInt()

    if(age>=18)
    {
        println("Eligible to vote")

        if(age>=50) //nested if
        {
            println("Senior Citizen")
        }
        else
        {
            println("Young Age")
        }
    }
    else
    {
        println("Not Eligible to vote")
    }


}