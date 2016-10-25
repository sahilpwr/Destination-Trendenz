<?php
include "connection.php";
$query=mysqli_query($con,"Select * from top_clusters ");
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

    $node=$doc->createElement("cluster");
    $id=$doc->createElement("id");
    $id->appendChild($doc->createTextNode($row['id']));
    $node->appendChild($id);

	$cid=$doc->createElement("cid");
    $cid->appendChild($doc->createTextNode($row['cluster_id']));
    $node->appendChild($cid);
	
    $lat=$doc->createElement("latitude");
    $lat->appendChild($doc->createTextNode($row['Latitude']));
    $node->appendChild($lat);
	
	$lon=$doc->createElement("longitude");
    $lon->appendChild($doc->createTextNode($row['Longitude']));
    $node->appendChild($lon);

    $root->appendChild($node);
}


echo $doc->saveXML();
mysqli_close($con);
?>