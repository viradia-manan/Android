import java.io.FileOutputStream



fun main()
{

    var fout = FileOutputStream("D://fetch-data.txt")


    println("Enter the name")
    var name = readLine()

    println("Enter the surname")
    var surname = readLine()

    println("Enter the email")
    var email = readLine()

    var email1 = "@"

    println("Enter the password")
    var pass = readLine()

    println("Enter the confirm password")
    var cpass = readLine()

    var name1 = "Name: $name, Surname: $surname, Email: $email, Password:$pass, Confirm Password: $cpass"
    if(email!!.contains(email1))
    {
        if(pass == cpass)
        {
            fout.write(name1.toByteArray())
        }
        else
        {
            println("Password does not match")
        }
    }
    else
    {
        println("Email in not valid")
    }








}