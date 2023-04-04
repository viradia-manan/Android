import java.io.FileOutputStream

fun main()
{

    var data = "Hello Manan"
    var fout = FileOutputStream("D://data.txt")
    fout.write(data.toByteArray())
}