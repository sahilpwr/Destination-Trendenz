<?php
	include "connection.php";
	$table=$_GET['table'];
	//echo $table;
	$query=mysqli_query($con,"truncate table ".$table);

	$number=mysqli_num_rows($query);

	if (!$number)
	{
	echo "0 rows Affected"; 

	}
	else
	{	
		echo 1;
	}
	mysqli_close($con);
?>