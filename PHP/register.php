<?php
	$con=mysqli_connect("mysql.1freehosting.com","u476429938_amrit","renovild","u476429938_ren1");
	$name=$_POST["Name"];
	$username=$_POST["Username"];
	$password=$_POST["Password"];
	$phone=$_POST["Phone"];
	$email=$_POST["Email"];
	$statement=mysqli_prepare($con,"INSERT INTO Credentials (Name,Username,Password,Phone,Email) VALUES (?,?,?,?,?)");

	mysqli_stmt_bind_param($statement,"sssss",$name,$username,$password,$phone,$email);
	mysqli_stmt_execute($statement);
	$response=array();
	$response["success"]=true;
	echo json_encode($response);
?>



