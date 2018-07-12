  <?php
    $con = mysqli_connect("localhost", "root", "", "facturacion_app");
    
    $clave_producto = $_POST["clave_producto"];
    $desc_producto = $_POST["desc_producto"];
    $precio = $_POST["precio"];
    $existencias = $_POST["existencias"];
    $codigo_barras = $_POST["codigo_barras"];
    $statement = mysqli_prepare($con, "INSERT INTO catalogos (clave_producto, desc_producto, precio, existencias, codigo_barras)
     VALUES (?, ?, ?, ?,?)");
    mysqli_stmt_bind_param($statement, "sssss", $clave_producto, $desc_producto,$precio,$existencias, $codigo_barras);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
    ?>