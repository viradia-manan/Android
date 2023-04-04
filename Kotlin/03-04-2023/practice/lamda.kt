class MyFirstClass3
{
    fun addTwoNum(a: Int , b : Int, action: (Int) ->Unit)
    {
        val sum = a+b
        action(sum)
    }
}
fun main()
{
    //lambda function
    val my = MyFirstClass3()
    val myLambda : (Int) -> Unit={s : Int ->println(s)}
    my.addTwoNum(2,7,myLambda)
}