<?php
	$Username = $_POST['Username'];
	$Password = $_Password['Password'];

	//Database connection
	$conn = new mysqli('localhost', 'root', '', 'dump');
	if($conn->connect_error){
		die('Connection Failed : '.$conn->connect_error);
	}else{
		$stmt = $conn->prepare("insert into registeration(Username, Password)
			values(?,?)");
		$stmt->bind_param("ss", $Username, $Password);
		$stmt->execute();
		echo "registered Successfully...";
		$stmt->close();
		$conn->close();
?>