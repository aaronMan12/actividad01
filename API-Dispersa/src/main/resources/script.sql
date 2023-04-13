CREATE DATABASE IF NOT EXISTS alumnos_spring;
USE alumnos_spring;
CREATE USER 'admin_sp_admn'@'localhost' IDENTIFIED BY 'admin_sp_admn';
CREATE USER 'admin_sp_admn'@'%' IDENTIFIED BY 'admin_sp_admn';
GRANT ALL PRIVILEGES ON saludos.* to 'admin_sp_admn'@'localhost';
GRANT ALL PRIVILEGES ON saludos.* to 'admin_sp_admn'@'%';
FLUSH PRIVILEGES;