<?php
	$con=mysqli_connect("mysql.1freehosting.com","u476429938_amrit","renovild","u476429938_ren1");
	$name=$_POST["Name"];
	$lat=$_POST["Lat"];
	$lon=$_POST["Long"];
	$statement=mysqli_prepare($con,"INSERT INTO Save (Name,Latitude,Longitude) VALUES (?,?,?)");
	mysqli_stmt_bind_param($statement,"sss",$name,$lat,$lon);
	mysqli_stmt_execute($statement);
	$response=array();
	$response["success"]=true;
	echo json_encode($response);
?>



