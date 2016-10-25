<?php
	include "connection.php";
	$cid=$_GET['cid'];
	$name=$_GET['name'];
	$type=$_GET['type'];
	echo "name =".$name." type=".$type;
	$status=mysqli_query($con,"insert into places values('','".$cid."','".$name."','".$type."')");

	mysqli_close($con);

?>