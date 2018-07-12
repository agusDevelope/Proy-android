<?php

//conexion a la base de datos
$con = mysqli_connect("localhost", "root", "", "facturacion_app");
//chequeo a la conexion a la base de datos
if(mysqli_connect_errno()){
	echo "fallo la conexion: " .mysqli_error(); die();
}
 //creacion del query
 $stmt = $con -> prepare("SELECT * from catalogos;");
 //ejecucion del query
 $stmt -> execute();
 //Vinculacion de datos de la consulta
 $stmt -> bind_result($clave_producto, $descripcion, $precio, $existencias, $codBarras);
 //
 $productos= array();

 //navegando a traves del resulset
 while ($stmt -> fetch()) {
 	# code...
 	$temp = array();
 	$temp['clave_producto'] =$clave_producto;
 	$temp['desc_producto'] =$descripcion;
 	$temp['precio'] =$precio;
 	$temp['existencias'] = $existencias;
 	$temp['codigo_barras'] = $codBarras;
 	array_push($productos,$temp);
 }

 echo json_encode(array('success' => true,'productos' => $productos));

?>