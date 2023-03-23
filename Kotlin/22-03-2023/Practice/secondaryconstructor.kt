class Tops2
{
    constructor(id:Int)
    {
        println("$id")
    }

    constructor(id:Int,name:String)
    {
        println("$id , $name")
    }

    constructor(id:Int,name:String,surname:String)
    {
        println("$id , $name , $surname")
    }


}
fun main()
{
    var t1 =Tops2(101,"Manan")
    var t2=Tops2(102,"Rutvik","Babriya")

}