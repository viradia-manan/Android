<?php 
	
//importing dbDetails file 
include 'connection.php';	

	
	
//getting name from the request 
 $img = $_POST['product_image'];
 $email = $_POST['email'];
 $name = $_POST['product_name'];
 $price = $_POST['product_price'];
 $pay = $_POST['payment'];
 
        $sql = "INSERT INTO `ag_order`(`product_image`, `email`, `product_name`, `product_price`, `payment_method`) VALUES ('$img','$email','$name','$price','$pay')";
        $ex=mysqli_query($con,$sql);

//exit;

			
//closing the connection 
mysqli_close($con);

?>