CREATE DATABASE javautn;
USE javautn;

CREATE TABLE equipo (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY,
    titulares INT,
    suplentes INT,
    directorTecnico VARCHAR(50),
    puntos INT,
    partidosJugados INT);

INSERT INTO equipo (nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados)
VALUES 
    ('River Plate', 11, 7, 'Marcelo Gallardo', 32, 15),
    ('Boca Juniors', 11, 7, 'Miguel Ángel Russo', 30, 15),
    ('Independiente', 11, 7, 'Julio César Falcioni', 27, 15),
    ('Racing Club', 11, 7, 'Juan Antonio Pizzi', 25, 15),
    ('San Lorenzo', 11, 7, 'Juan Antonio Pizzi', 24, 15),
    ('Vélez Sarsfield', 11, 7, 'Mauricio Pellegrino', 22, 15),
    ('Estudiantes de La Plata', 11, 7, 'Ricardo Zielinski', 20, 15),
    ('Huracán', 11, 7, 'Israel Damonte', 18, 15),
    ('Argentinos Juniors', 11, 7, 'Gabriel Milito', 17, 15),
    ('Newells Old Boys', 11, 7, 'Frank Kudelka', 16, 15);
    
SELECT * FROM javautn.equipo;