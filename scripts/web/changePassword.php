<?php

$host = "localhost"; // Host name
$username = "root"; // Mysql username
$password = "root"; // Mysql password
$db_name = "target_exemplar"; // Database name
$name = "contractor@fazio.com";
$new_passward = password_hash($argv[1], PASSWORD_DEFAULT);

try {
	// Connect to server and select database.
	$conn = new PDO('mysql:host=' . $host . ';dbname=' . $db_name . ';charset=utf8', $username, $password);
	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

	$sql = "UPDATE members SET password = '" . $new_passward . "' WHERE username = '" . $name . "'";
	echo $sql;
	$stmt = $conn->prepare($sql);
    $stmt->execute();
    echo $stmt->rowCount();

} catch (\Exception $e) {
	die('Database connection error');
}

?>
