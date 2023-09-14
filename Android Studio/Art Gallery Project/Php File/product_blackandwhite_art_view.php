<?php
    
    include('connection.php');
    $category = "Black & White";
    $sql="SELECT * FROM `ag_colourfull_art` WHERE product_category ='$category'";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["product_name"]=$row["product_name"];
        $value["product_price"]=$row["product_price"];
        $value["product_image"]=$row["product_image"];
          $value["product_des"]=$row["product_des"];
      

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>