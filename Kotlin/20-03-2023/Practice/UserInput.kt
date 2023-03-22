fun main()
{

    println("Enter Your Name")
    var name = readLine()

    println("Enter Your Number")
    var number = readLine()!!.toBigInteger()


    var email1 ="@"


    println("Enter Your Email")
    var email = readLine()


    if(email!!.contains(email1))
    {
        println("Email id is valid")
        println("Your name is $email")
    }
    else
    {
        println("Email id is not valid")
    }



    println("Your name is $name")
    println("Your number is $number")


}