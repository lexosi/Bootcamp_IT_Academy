DROP DATABASE IF EXISTS youtube;
CREATE DATABASE youtube CHARACTER SET utf8mb4;
USE youtube;

CREATE TABLE usuario (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo ENUM('H', 'M') NOT NULL,
    pais VARCHAR(50) NOT NULL,
    codigo_postal VARCHAR(10) NOT NULL
);

CREATE TABLE video (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    tamano INT UNSIGNED NOT NULL,
    nombre_archivo VARCHAR(100) NOT NULL,
    duracion TIME NOT NULL,
    thumbnail VARCHAR(100) NOT NULL,
    num_reproducciones INT UNSIGNED NOT NULL,
    num_likes INT UNSIGNED NOT NULL,
    num_dislikes INT UNSIGNED NOT NULL,
    estado ENUM('publico', 'oculto', 'privado') NOT NULL,
    id_usuario INT UNSIGNED NOT NULL,
    fecha_publicacion DATETIME NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE etiqueta (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE video_etiqueta (
    id_video INT UNSIGNED NOT NULL,
    id_etiqueta INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_video, id_etiqueta),
    FOREIGN KEY (id_video) REFERENCES video(id),
    FOREIGN KEY (id_etiqueta) REFERENCES etiqueta(id)
);

CREATE TABLE canal (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    fecha_creacion DATE NOT NULL,
    id_usuario INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE suscripcion (
    id_usuario INT UNSIGNED NOT NULL,
    id_canal INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_usuario, id_canal),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_canal) REFERENCES canal(id)
);

CREATE TABLE like_dislike (
    id_usuario INT UNSIGNED NOT NULL,
    id_video INT UNSIGNED NOT NULL,
    tipo ENUM('like', 'dislike') NOT NULL,
    fecha_hora DATETIME NOT NULL,
    PRIMARY KEY (id_usuario, id_video),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_video) REFERENCES video(id)
);

CREATE TABLE playlist (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estado ENUM('publica', 'privada') NOT NULL,
    id_usuario INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);

CREATE TABLE video_playlist (
    id_video INT UNSIGNED NOT NULL,
    id_playlist INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_video, id_playlist),
    FOREIGN KEY (id_video) REFERENCES video(id),
    FOREIGN KEY (id_playlist) REFERENCES playlist(id)
);

CREATE TABLE comentario (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    texto TEXT NOT NULL,
    fecha_hora DATETIME NOT NULL,
    id_usuario INT UNSIGNED NOT NULL,
    id_video INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_video) REFERENCES video(id)
);

CREATE TABLE comentario_like_dislike (
    id_usuario INT UNSIGNED NOT NULL,
    id_comentario INT UNSIGNED NOT NULL,
    tipo ENUM('like', 'dislike') NOT NULL,
    fecha_hora DATETIME NOT NULL,
    PRIMARY KEY (id_usuario, id_comentario),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_comentario) REFERENCES comentario(id)
);