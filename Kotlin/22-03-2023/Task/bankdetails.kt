import java.math.BigInteger

class bankdetails
{
    constructor(id:Int, name:String, num:BigInteger, ac_no:BigInteger)
    {
        println("Id: $id, Name: $name, Mobile No.: $num, Account Number: $ac_no")
    }

    constructor(id:Int,name:String,num:BigInteger,ac_no:BigInteger, address:String)
    {
        println("Id: $id, Name: $name, Mobile No.: $num, Account Number: $ac_no, Address: $address")
    }
}

fun main()
{
    println("Enter Your Id")
    var id = readLine()!!.toInt()

    println("Enter Your Name")
    var name = readLine()

    println("Enter Your Mobile No.")
    var num = readLine()!!.toBigInteger()

    println("Enter Your Account No.")
    var acNo = readLine()!!.toBigInteger()

    println("Enter Your Address")
    var address = readLine()

    var fourDetail = bankdetails(id, "$name", num, acNo)
    var allDetails = bankdetails(id, "$name", num, acNo, "$address")


}