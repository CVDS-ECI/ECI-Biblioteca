create table if not exists Rol(
id SERIAL primary key ,
nombre varchar(50));


CREATE TABLE IF NOT EXISTS Usuario(
  correo varchar(45)NOT NULL,
  contraseña varchar(45)not null,
  rol int references Rol(id),
  u_area varchar(45) not null,
  nombre VARCHAR(45) NOT NULL,
  PRIMARY KEY (correo))
;


CREATE TABLE IF NOT EXISTS Recurso (
  id SERIAL,
  nombre varchar(45) not null,
  ubicacion varchar(45) not null,
  tipo varchar(45) not null,
  capacidad int not null,
  estado varchar(45) not null,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS Reserva (
  id SERIAL,
  tipo varchar(45) not null,
  fecha_fin DATE,
  periodicidad varchar(45),
  estado varchar(45) not null,
  usuario varchar(45) NOT NULL REFERENCES Usuario(correo),
  recurso INTEGER NOT NULL REFERENCES Recurso(id),
  PRIMARY KEY (id));