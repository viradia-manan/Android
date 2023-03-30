fun fib() {
    var num = 20
   var a = 0
    var b = 1
    var c = 0

    while (a<num)
    {
        println(a)
        c = a+b
        a=b
        b=c
    }
}

fun main()
{
    fib()
}


