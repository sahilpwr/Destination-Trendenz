<?php
include "connection.php";
$query=mysqli_query($con,"Select * from area");
$number=mysqli_num_rows($query);

if (!$query)
{
echo "0 rows Affected"; 

}
/*
$doc= new DOMDocument();
$doc->formatOutput=true;

$root= $doc->createElement("place");
$doc->appendChild($root);

while($row=mysqli_fetch_array($query)){

    $node=$doc->createElement("point");
    $id=$doc->createElement("id");
    $id->appendChild($doc->createTextNode($row['Id']));
    $node->appendChild($id);

    $lat=$doc->createElement("latitude");
    $lat->appendChild($doc->createTextNode($row['Latitude']));
    $node->appendChild($lat);
	
	$lon=$doc->createElement("longitude");
    $lon->appendChild($doc->createTextNode($row['Longitude']));
    $node->appendChild($lon);

    $root->appendChild($node);
}


echo $doc->saveXML();*/
$final_string="blank";
while($row=mysqli_fetch_array($query))
{
	$final_string=$final_string.",".$row['name'];
}
echo $final_string;
?>