<?php
include "connection.php";
$query=mysqli_query($con,"Select * from points ");
$number=mysqli_num_rows($query);

if (!$query)
{
echo "0 rows Affected"; 

}

$doc= new DOMDocument();
$doc->formatOutput=true;

$root= $doc->createElement("result");
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


echo $doc->saveXML();
?>