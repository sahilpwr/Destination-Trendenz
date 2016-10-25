<?php
/*
 $DBPassword="xn7WG1M6";
 $DBHost="localhost";
 $DBUser="b11_17595202";
 $DBName="b11_17595202_gps";
global $con;
$con=mysqli_connect($DBHost,$DBUser,$DBPassword,$DBName);
mysqli_select_db($con,$DBName);
*/
 $DBPassword="";
 $DBHost="localhost";
 $DBUser="root";
 $DBName="gps";
global $con;
$con=mysqli_connect($DBHost,$DBUser,$DBPassword,$DBName);
mysqli_select_db($con,$DBName);
?>