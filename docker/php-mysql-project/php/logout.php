<?php
$servername = "mysql";
$username = "admin";
$password = "admin";
$dbname = "dbproducts";

// Obtener datos del POST
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, true);

// Verificar si se recibieron datos válidos
if ($input && isset($input['id'])) {

    // Crear conexión
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    // Escapar los datos de entrada para evitar SQL injection
    $id = mysqli_real_escape_string($conn, $input['id']);

    // Consulta SQL para actualizar el estado de la sesión a 'inactive'
    $sql = "UPDATE TBSession SET state = 'inactive' WHERE id = '$id'";

    if ($conn->query($sql) === TRUE) {
        $response = array(
            "message" => "sesión cerrada",
            "isValid" => true
        );
    } else {
        $response = array(
            "message" => "Error al cerrar la sesión: " . $conn->error,
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
