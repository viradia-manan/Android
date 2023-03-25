fun main()
{
    var sum = 0
    var lastdigit = 0

    println("Enter The Number")
    var num = readLine()!!.toInt()

    lastdigit = num%10
    sum = (sum*10)+lastdigit

    while(num > 0)
    {
        if(num > 9)
            num = num/10
        else
        {
            lastdigit = num
            sum = sum+lastdigit
            num = num/10
        }
    }

    println("First & Last Digit is: $sum")
}