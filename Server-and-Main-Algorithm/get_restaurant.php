<?php
include "connection.php";
$query=mysqli_query($con,"Select * from places where type=1");
$number=mysqli_num_rows($query);

if (!$query)
{
echo "0 rows Affected"; 

}
$json = array();
//$result = mysqli_query ($connection, $query);
while($row = mysqli_fetch_array ($query))     
{
    $json[]=$row;
}

$jsonstring = json_encode($json);
echo $jsonstring;
echo"";

echo json_decode($jsonstring);

/*
$doc= new DOMDocument();
$doc->formatOutput=true;

$root= $doc->createElement("result");
$doc->appendChild($root);

while($row=mysqli_fetch_array($query)){

    $node=$doc->createElement("place");
    $id=$doc->createElement("id");
    $id->appendChild($doc->createTextNode($row['id']));
    $node->appendChild($id);

    $name=$doc->createElement("name");
    $name->appendChild($doc->createTextNode($row['name']));
    $node->appendChild($name);

    $root->appendChild($node);
}


echo $doc->saveXML();
/*

$final_string="blank";
while($row=mysqli_fetch_array($query))
{
	$final_string=$final_string.",".$row['name'];
}
echo $final_string;
*/
?>