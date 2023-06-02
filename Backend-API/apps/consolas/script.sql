CREATE DATABASE IF NOT EXISTS api_consolas;
USE api_consolas;
CREATE USER 'admin_consolas'@'localhost' IDENTIFIED BY 'admin_consolas';
CREATE USER 'admin_consolas'@'%' IDENTIFIED BY 'admin_consolas';
GRANT ALL PRIVILEGES ON api_consolas.* TO 'admin_consolas'@'localhost';
GRANT ALL PRIVILEGES ON api_consolas.* TO 'admin_consolas'@'%';
FLUSH PRIVILEGES;