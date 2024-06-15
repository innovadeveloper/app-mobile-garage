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

// Query SQL para seleccionar todos los usuarios
$sql = "SELECT * FROM TBUsuario";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $usuarios = array();
    while($row = $result->fetch_assoc()) {
        // Construir cada fila como un array asociativo
        $usuario = array(
            "id" => $row["id"],
            "username" => $row["username"],
            "password" => $row["password"],
            "createdAt" => $row["createdAt"],
            "state" => $row["state"],
            "role" => $row["role"]
        );
        // Agregar el usuario al array de usuarios
        $usuarios[] = $usuario;
    }
    // Convertir el array de usuarios a formato JSON
    header('Content-Type: application/json');
    echo json_encode($usuarios);
} else {
    // No se encontraron usuarios
    echo "No se encontraron usuarios.";
}

// Cerrar conexión
$conn->close();
?>
