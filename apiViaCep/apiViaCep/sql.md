CREATE DATABASE IF NOT EXISTS seubanco;
USE seubanco;

CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(9),
    logradouro VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2)
);
