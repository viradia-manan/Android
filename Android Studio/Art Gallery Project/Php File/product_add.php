<?php 
	
//importing dbDetails file 
include 'connection.php';	

//this is our upload folder 
$upload_path = 'uploads/';

//Getting the server ip 
// $server_ip = gethostbyname(gethostname());

//creating the upload url 
// $upload_url = $upload_path; 
$upload_url = 'https://'.$_SERVER['SERVER_NAME'] . "/art_gallery/" . $upload_path;

//echo $upload_url;
	
//getting name from the request 
$name = $_POST['product_name'];
$category = $_POST["product_category"];
$price = $_POST["product_price"];
$des = $_POST['product_des'];


					
//getting file info from the request 
$fileinfo = pathinfo($_FILES["url"]["name"]);

//getting the file extension 
$extension = $fileinfo["extension"];

$random = 'image_' . rand(1000,9999);

//file url to store in the database 
$file_url = $upload_url . $random . '.' . $extension;

//file path to upload in the server 
$file_path = $upload_path . $random . '.'. $extension; 
			
//saving the file 
move_uploaded_file($_FILES["url"]["tmp_name"],$file_path);




$sql = "INSERT INTO `ag_colourfull_art`(`product_name`, `product_price`, `product_image`, `product_des`, `product_category`) VALUES ('$name','$price','$file_url','$des','$category')";
//echo $sql;
//exit;
$ex=mysqli_query($con,$sql);
			
//closing the connection 
mysqli_close($con);

?>