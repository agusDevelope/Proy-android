    <?php
    $con = mysqli_connect("localhost", "root", "", "facturacion_app");
    
    $nombre = $_POST["nombre"];
    $apellidos = $_POST["apellidos"];
    $empresa = $_POST["empresa"];
    $email = $_POST["email"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO usuarios ( nombre, apellidos, empresa, email, password)
     VALUES (?, ?, ?, ?,?)");
    mysqli_stmt_bind_param($statement, "sssss", $nombre, $apellidos,$empresa,$email, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>