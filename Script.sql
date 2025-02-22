CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,                  
    nombre VARCHAR(50) NOT NULL,         
    apellido VARCHAR(50) NOT NULL,           
    identificacion VARCHAR(20) UNIQUE NOT NULL, 
    edad INT NOT NULL,                     
    fechaRegistro VARCHAR(20) NOT NULL,     
    correo VARCHAR(100) UNIQUE NOT NULL,     
    cuenta VARCHAR(20) UNIQUE NOT NULL       
);
