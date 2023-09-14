<?php

    include('connection.php');
    
    $name = $_POST["name"];
    $email = $_POST["email"];
    $pass = $_POST["password"];
   

        $sql ="INSERT INTO `ag_reg`(`name`, `email`, `password`) VALUES ('$name','$email','$pass')";
        mysqli_query($con,$sql);

    

?>