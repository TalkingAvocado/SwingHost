<?php

include 'ServerCredentials.php';

$inputData = file_get_contents("php://input");
$data = json_decode($inputData);

$t = $data->data;


$returnObj = new stdClass();
$returnObj->test = "Hello World";

echo json_encode($returnObj);



?>