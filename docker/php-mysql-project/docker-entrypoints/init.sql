-- Tabla para usuarios
CREATE TABLE TBUsuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    state ENUM('active', 'inactive') NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Tabla para sesiones
CREATE TABLE TBSession (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    state ENUM('active', 'inactive') NOT NULL
);

-- Tabla para entidades de garage
CREATE TABLE TbGarageEntity (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    position INT NOT NULL,
    state VARCHAR(50) NOT NULL
);

INSERT INTO TBUsuario (username, password, createdAt, state, role)
VALUES ('user1', 'password1', '2024-06-14 10:00:00', 'active', 'admin');

INSERT INTO TBUsuario (username, password, createdAt, state, role)
VALUES ('user2', 'password2', '2024-06-14 11:30:00', 'active', 'user');

INSERT INTO TBUsuario (username, password, createdAt, state, role)
VALUES ('user3', 'password3', '2024-06-14 12:15:00', 'inactive', 'user');

INSERT INTO TBUsuario (username, password, createdAt, state, role)
VALUES ('user4', 'password4', '2024-06-14 13:00:00', 'active', 'user');

INSERT INTO TBUsuario (username, password, createdAt, state, role)
VALUES ('user5', 'password5', '2024-06-14 14:45:00', 'active', 'admin');
