<?php 

include 'connection.php';

$email=$_POST["email"];
$pass=$_POST["password"];


$sel="select * from `ag_reg` where email='$email' and password = '$pass'";

$ex = mysqli_query($con,$sel);

$no=mysqli_num_rows($ex);
//echo $no;


if($no>0)
{
$fet=mysqli_fetch_object($ex);
echo json_encode(['code'=>200]);
}
else
{
echo "0";
}



?>