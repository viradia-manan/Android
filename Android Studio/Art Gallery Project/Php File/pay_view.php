<?php
    
    include('connection.php');
    
    $email = $_POST["email"];
    
    $sql="SELECT * FROM `ag_order` where email='$email'";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["product_image"]=$row["product_image"];
        $value["product_name"]=$row["product_name"];
        $value["product_price"]=$row["product_price"];
          
      

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>