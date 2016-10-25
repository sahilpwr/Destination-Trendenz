<?php

	$cid=$_GET['cid'];
	$lat=$_GET['lat'];
	$lon=$_GET['lon'];
	$num=$_GET['num'];
	
	include "connection.php";
	
	$status=mysqli_query($con,"insert into clusters values('','".$cid."','".$lat."','".$lon."','".$num."')");
	if($status)
		echo 1;
	else
		echo 0;
?>