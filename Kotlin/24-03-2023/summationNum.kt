fun main()
{
        var lastdigit = 0

        println("Enter Your Number")
        var num = readLine()!!.toInt()

        while (num > 0)
        {
                lastdigit = lastdigit+num%10
                num = num/10
        }

        println("Number summation is : $lastdigit")
}