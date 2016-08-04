<?php
	$con=mysqli_connect("mysql.1freehosting.com","u476429938_amrit","renovild","u476429938_ren1");
	$username=$_POST["Username"];
	$password=$_POST["Password"];
	$statement=mysqli_prepare($con,"SELECT *  FROM Credentials WHERE Username=? AND Password=?");
	mysqli_stmt_bind_param($statement,"ss",$username,$password);
	mysqli_stmt_execute($statement);

	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement,$ID,$Name,$Username,$Password,$Phone,$Email);
	$response=array();
	$response["success"]=false;

	while(mysqli_stmt_fetch($statement))
	{
		$response["success"]=true;
		$response["Name"]=$Name;
		$response["Username"]=$Username;
		$response["Password"]=$Password;
		$response["Phone"]=$Phone;
		$response["Email"]=$Email;
		
	}	
	echo json_encode($response);
?>