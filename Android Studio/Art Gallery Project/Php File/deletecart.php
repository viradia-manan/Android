<?php

include('connection.php');
//$email=$_POST["email"];
$id = $_POST["id"];


$sql="Delete from ag_fav where/* product_email ='$email' and*/ id='$id'";


//$ex=mysqli_query($con,$sql);

if(mysqli_query($con,$sql))
{
    echo 'Record Deleted Succesfully';
}
else
{
    echo 'Something went Wrong';
}


?>