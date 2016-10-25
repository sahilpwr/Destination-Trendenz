<?php
include "connection.php";
$lat=$_POST['latitude'];
$lon=$_POST['longitude'];
$query=mysqli_query($con,"insert into points values('','".$lat."','".$lon."')");
$number=mysqli_num_rows($query);
mysqli_close($con);
?>