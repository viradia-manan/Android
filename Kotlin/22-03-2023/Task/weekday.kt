fun main()
{
    println("Enter Weekday(Start Monday to end Sunday)")
    var weekday = readLine()!!.toInt()

    when(weekday)
    {
        1->
        {
            println("Monday")
        }
        2->
        {
            println("Tuesday")
        }
        3->
        {
            println("Wednesday")
        }
        4->
        {
            println("Thursday")
        }
        5->
        {
            println("Friday")
        }
        6->
        {
            println("Saturday")
        }
        7->
        {
            println("Sunday")
        }
    }
}