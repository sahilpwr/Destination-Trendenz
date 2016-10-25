<?php

	$cid=$_GET['id'];
	$lat=$_GET['name'];
	$lon=$_GET['type'];
	
	include "connection.php";
	
	$status=mysqli_query($con,"insert into clusters values('','".$cid."','".$lat."','".$lon."')");
	if($status)
		echo 1;
	else
		echo 0;
	mysqli_close($con);
?>