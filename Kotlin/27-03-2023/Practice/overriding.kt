open class bank
{
    open fun rate():Int
    {
        return 0
    }
}

class sbi:bank()
{
    override fun rate():Int
    {
        return 7
    }
}

class icici:bank()
{
    override fun rate():Int
    {
        return 8
    }
}

class axis:bank()
{
    override fun rate():Int
    {
        return 9
    }
}

fun main()
{
    var b = bank() //refrence variable

    // sbi

    b=sbi()
    println(b.rate())

    // icici

    b=icici()
    println(b.rate())

    // axis
    b=axis()
    println(b.rate())
}