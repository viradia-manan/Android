<?php
    
    include('connection.php');
    $email = $_POST['product_email'];
    
    $sql="SELECT * FROM `ag_fav` where product_email='$email'";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["product_name"]=$row["product_name"];
        $value["product_price"]=$row["product_price"];
        $value["img"]=$row["img"];
      
        //$value["product_email"]=$row["product_email"];
        //$value["product_des"]=$row["product_des"];
      

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>