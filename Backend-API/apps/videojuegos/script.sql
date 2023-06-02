CREATE DATABASE IF NOT EXISTS api_videojuegos;
USE api_videojuegos;
CREATE USER 'admin_videojuegos'@'localhost' IDENTIFIED BY 'admin_videojuegos';
CREATE USER 'admin_videojuegos'@'%' IDENTIFIED BY 'admin_videojuegos';
GRANT ALL PRIVILEGES ON api_videojuegos.* TO 'admin_videojuegos'@'localhost';
GRANT ALL PRIVILEGES ON api_videojuegos.* TO 'admin_videojuegos'@'%';
FLUSH PRIVILEGES;