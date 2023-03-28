import java.math.BigInteger

open class employee
{
    fun specialization()
    {
        println()
    }
}

open class manager :employee()
{
    fun department()
    {
        println()
    }
}

class member :manager()
{

    fun data(name:String, age:Int, phone_no:BigInteger, address:String, salary:Int) {
        println("Name: $name, Age: $age, Phone: $phone_no, Address: $address, Salary: $salary")
    }
}

fun main()
{
    println("Enter the name")
    var name = readLine()

    println("Enter the age")
    var age = readLine()!!.toInt()

    println("Enter the phone number")
    var ph_no = readLine()!!.toBigInteger()

    println("Enter the address")
    var address = readLine()

    println("Enter the salary")
    var salary = readLine()!!.toInt()

    var printsalary = member()

    println(printsalary.data("$name",age,ph_no,"$address",salary))

}