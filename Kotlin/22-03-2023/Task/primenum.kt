fun main()
{
    println("Enter Number")
    var num = readLine()!!.toInt()

    if(num%2==0)
        {
            println("$num Number is not Prime")
        }
        else
        {
            println("$num Number is Prime")
        }

}