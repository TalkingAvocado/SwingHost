<?php

include 'ServerCredentials.php';

$inputData = file_get_contents("php://input");
$data = json_decode($inputData);

$t = $data->data;

echo "Result: ".$t;



?>