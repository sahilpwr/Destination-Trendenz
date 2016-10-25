$query=mysql_query("Select * from gamesleaderboard ");

$number=mysql_num_rows($query);

if ($query==0)
{
echo "0 rows Affected"; 

}

$doc= new DOMDocument();
$doc->formatOutput=true;

$root= $doc->createElement("Games");
$doc->appendChild($root);

for ($i=0; $i<$number; $i++){

    $row=mysql_fetch_array($qex);

    $node=$doc->createElement("user");
    $pn=$doc->createElement("player_name");
    $pn->appendChild($doc->createTextNode($row["player_name"]));
    $node->appendChild($pn);

    $sc=$doc->createElement("score");
    $sc->appendChild($doc->createTextNode($row["score"]));
    $node->appendChild($sc);

    $root->appendChild($node);
}


echo $doc->saveXML();