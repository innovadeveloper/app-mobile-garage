<?php
$servername = "mysql";
$username = "admin";
$password = "admin";
$dbname = "dbproducts";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Consulta SQL para obtener todos los registros de TbGarageEntity
$sql = "SELECT id, username, position, state FROM TbGarageEntity";
$result = $conn->query($sql);

$garageEntities = array();

if ($result->num_rows > 0) {
    // Salida de datos de cada fila
    while($row = $result->fetch_assoc()) {
        $garageEntities[] = $row;
    }
}

// Devolver la respuesta como JSON con UTF-8
header('Content-Type: application/json; charset=utf-8');
echo json_encode($garageEntities, JSON_UNESCAPED_UNICODE); // Evitar escapar caracteres Unicode

// Cerrar conexión
$conn->close();
?>
