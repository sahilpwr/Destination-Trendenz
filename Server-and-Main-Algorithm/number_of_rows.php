<?php
include "connection.php";
$table=$_GET['table'];
//echo $table;
$query=mysqli_query($con,"Select count(*) from ".$table);

$number=mysqli_num_rows($query);

if ($number)
{
	//echo "sucessful";
}
else
{
	echo "0 rows Affected"; 
}

$doc= new DOMDocument();
$doc->formatOutput=true;

$root= $doc->createElement("result");
$doc->appendChild($root);

while($row=mysqli_fetch_array($query)){

	$one= $doc->createElement("count");
	$one->appendChild($doc->createTextNode($row[0]));
	$root->appendChild($one);
}


echo $doc->saveXML();
mysqli_close($con);
?>