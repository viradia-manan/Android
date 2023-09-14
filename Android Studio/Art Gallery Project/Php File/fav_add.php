<?php 
	
//importing dbDetails file 
include 'connection.php';	

//this is our upload folder 
$upload_path = 'fav_img/';

//Getting the server ip 
$server_ip = gethostbyname(gethostname());

//creating the upload url 
//$upload_url = 'http://'.$server_ip.'/animal/'.$upload_path; 

$upload_url = 'https://'.$_SERVER['SERVER_NAME'] . "/art_gallery/" . $upload_path;
	
	
//getting name from the request 
 $name = $_POST['product_name'];
 $price = $_POST['product_price'];
 $count = $_POST['product_count'];
 $email = $_POST['product_email'];
 $img = $_POST["img"];

//getting file info from the request 
$fileinfo = pathinfo($_FILES["img"]["name"]);

//getting the file extension 
$extension = $fileinfo["extension"];

//file url to store in the database 
$file_url = $upload_url . $name . '.' . $extension;

//file path to upload in the server 
$file_path = $upload_path . $name . '.'. $extension; 
			
//saving the file 
move_uploaded_file($_FILES["img"]["tmp_name"],$file_path);


        $sql = "INSERT INTO ag_fav (product_name,product_price,img,product_email) VALUES ('$name','$price','$img','$email')";
        $ex=mysqli_query($con,$sql);

echo $sql;
//exit;

			
//closing the connection 
mysqli_close($con);

?>