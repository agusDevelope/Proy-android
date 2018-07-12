<?php
    $con = mysqli_connect("localhost", "root", "", "facturacion_app");
    
    $email = $_POST["email"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM usuarios WHERE email= ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $email, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $idusr, $nombre, $apellidos, $empresa, $email, $password);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["nombre"] = $nombre;
        $response["email"]= $email;
        $response["empresa"]=$empresa;
    }
    
    echo json_encode($response);
?>