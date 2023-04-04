class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }

}
//Extension Function
fun MyFirstClass.isScholar(marks: Int):Boolean
{
    return marks>90
}


fun main()
{
    var m1 = MyFirstClass()
    println(m1.hasPassed(88))
    println(m1.isScholar(88))

    var m2 = MyFirstClass()
    println(m2.hasPassed(95))
    println(m2.isScholar(95))





}