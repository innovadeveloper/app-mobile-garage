-- Tabla para usuarios
CREATE TABLE TBUsuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    state ENUM('active', 'inactive') NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Tabla para sesiones
CREATE TABLE TBSession (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    state ENUM('active', 'inactive') NOT NULL
);

-- Tabla para entidades de garage
CREATE TABLE TbGarageEntity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    position INT NOT NULL,
    state ENUM('RESERVADO', 'TOMADO', 'DISPONIBLE', 'ROW') NOT NULL
);

INSERT INTO TBUsuario (fullname, username, password, createdAt, state, role)
VALUES ('Kane Baltazar Alanoca', 'kenny', 'kenny', '2024-06-14 10:00:00', 'active', 'admin');

INSERT INTO TBUsuario (fullname, username, password, createdAt, state, role)
VALUES ('Javier Rafaele','javier', 'javier', '2024-06-14 11:30:00', 'active', 'user');

INSERT INTO TBUsuario (fullname, username, password, createdAt, state, role)
VALUES ('Marco Zarzoza','marco', 'marco', '2024-06-14 12:15:00', 'inactive', 'user');

INSERT INTO TBUsuario (fullname, username, password, createdAt, state, role)
VALUES ('Victor Sanchez','victor', 'victor', '2024-06-14 13:00:00', 'active', 'user');



-- insert garage docs
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 1, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES ('kenny', 2, 'RESERVADO');
INSERT INTO TbGarageEntity (username, position, state) VALUES ('javier', 3, 'TOMADO');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 4, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 5, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 6, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 7, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 8, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 9, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 10, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 11, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 12, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 13, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 14, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 15, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 16, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 17, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 18, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 19, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 20, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 21, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 22, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 23, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 24, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 25, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 26, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 27, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 28, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 29, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 30, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 31, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 32, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 33, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 34, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 35, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 36, 'ROW');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 37, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 38, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 39, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 40, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 41, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 42, 'DISPONIBLE');
INSERT INTO TbGarageEntity (username, position, state) VALUES (NULL, 43, 'ROW');
