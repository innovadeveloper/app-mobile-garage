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

// Insertar usuario por defecto
$sql = "INSERT INTO TbUsuario (nombre, apellidos, direccion, fecha_nacimiento, username) VALUES ('Juan', 'Pérez', 'Calle Falsa 123', '1980-01-01', 'juanperez')";

if ($conn->query($sql) === TRUE) {
    echo "Usuario por defecto registrado exitosamente";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Cerrar conexión
$conn->close();
?>
