CREATE DATABASE curso;
USE curso;

CREATE TABLE usuariosadministrador (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    cedula VARCHAR(20) NOT NULL,
    pass VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL
);

CREATE TABLE estudiantes (
    codigo_matricula INT PRIMARY KEY AUTO_INCREMENT,
    nombre_apellido VARCHAR(150) NOT NULL,
    direccion VARCHAR(255),
    edad INT,
    telefono VARCHAR(20),
    correo VARCHAR(100),
    nota1 FLOAT,
    nota2 FLOAT
);

INSERT INTO usuariosadministrador (nombre, cedula, pass, correo) 
VALUES ('Juan Pérez', '1234567890', 'QWERTY', 'juan.perez@example.com');

