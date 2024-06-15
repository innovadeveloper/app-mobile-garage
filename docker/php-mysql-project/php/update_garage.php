<?php
$servername = "mysql";
$username = "admin";
$password = "admin";
$dbname = "dbproducts";

// Obtener datos del POST
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, true);

// Verificar si se recibieron datos válidos
if ($input && isset($input['position']) && isset($input['username']) && isset($input['state'])) {

    // Crear conexión
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Verificar conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    // Escapar los datos de entrada para evitar SQL injection
    $position = mysqli_real_escape_string($conn, $input['position']);
    $username = mysqli_real_escape_string($conn, $input['username']);
    $state = mysqli_real_escape_string($conn, $input['state']);

    // Consulta SQL para actualizar el registro en TbGarageEntity
    $sql = "UPDATE TbGarageEntity SET username = '$username', state = '$state' WHERE position = '$position'";

    try {
        if ($conn->query($sql) === TRUE) {
            if ($conn->affected_rows > 0) {
                $response = array(
                    "message" => "registro exitoso",
                    "isValid" => true
                );
            } else {
                $response = array(
                    "message" => "no se encontró el registro con esa posición",
                    "isValid" => false
                );
            }
        } else {
            throw new Exception("Error al actualizar: " . $conn->error);
        }
    } catch (mysqli_sql_exception $e) {
        // Capturar la excepción de MySQL
        $response = array(
            "message" => "Error MySQL: " . $e->getMessage(),
            "isValid" => false
        );
    } catch (Exception $e) {
        // Capturar cualquier otra excepción
        $response = array(
            "message" => $e->getMessage(),
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
