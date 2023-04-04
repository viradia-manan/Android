class MyFirstClass2
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }

}
//infix Function
//it's only support 1 parameter

///all infix functions are extension but all extension are not infix

infix fun MyFirstClass2.isScholar(marks: Int):Boolean
{
    return marks>90
}


fun main()
{
    var m1 = MyFirstClass2()
    println(m1.hasPassed(88))
    println(m1.isScholar(88))

    var m2 = MyFirstClass2()
    println(m2.hasPassed(95))
    println(m2.isScholar(95))





}