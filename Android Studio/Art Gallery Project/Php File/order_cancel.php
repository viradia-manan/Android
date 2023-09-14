<?php
    
    include('connection.php');
    
    $id = $_POST["id"];
    $sql="DELETE FROM `ag_order` WHERE id='$id'";
    
    $r=mysqli_query($con,$sql);
    
?>