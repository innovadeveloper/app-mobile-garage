<?php
$servername = "mysql";
$username = "admin";
$password = "admin";
$dbname = "dbproducts";

// Obtener datos del POST
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, true);

// Verificar si se recibieron datos válidos
if ($input && isset($input['username']) && isset($input['password'])) {

    // Crear conexión
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    // Escapar los datos de entrada para evitar SQL injection
    $username = mysqli_real_escape_string($conn, $input['username']);
    $password = mysqli_real_escape_string($conn, $input['password']);

    // Consulta SQL para verificar las credenciales
    $sql = "SELECT * FROM TBUsuario WHERE username = '$username' AND password = '$password'";

    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        // Credenciales válidas
        $response = array(
            "message" => "sesión exitosa",
            "isValid" => true
        );
    } else {
        // Credenciales inválidas
        $response = array(
            "message" => "sesión fallida",
            "isValid" => false
        );
    }

    // Devolver la respuesta como JSON con UTF-8
    header('Content-Type: application/json; charset=utf-8');
    echo json_encode($response, JSON_UNESCAPED_UNICODE); // Evitar escapar caracteres Unicode

    // Cerrar conexión
    $conn->close();

} else {
    // Datos no recibidos correctamente
    $response = array(
        "message" => "error en la solicitud",
        "isValid" => false
    );
    // Devolver la respuesta como JSON con UTF-8
    header('Content-Type: application/json; charset=utf-8');
    echo json_encode($response, JSON_UNESCAPED_UNICODE); // Evitar escapar caracteres Unicode
}
?>