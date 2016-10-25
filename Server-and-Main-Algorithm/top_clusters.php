<?php
	include "connection.php";
	$num=$_GET['num'];
	$status=mysqli_query($con,"insert into top_clusters select * from clusters order by number_of_points limit ".$num);
	
	mysqli_close($con);

?>