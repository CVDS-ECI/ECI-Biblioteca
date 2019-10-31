create table if not exists Rol(
id SERIAL primary key ,
nombre varchar(50));

CREATE table if not exists  Usuario(

  correo varchar(50)NOT NULL,
  passwd varchar(50)not null,
  nombre VARCHAR(50) NOT NULL,
  rol int references Rol(id),
  programa varchar(50) not null,
  PRIMARY KEY (correo))
;

CREATE TABLE if not exists Recurso (
  id SERIAL,
  nombre varchar(50) not null,
  ubicacion varchar(50) not null,
  tipo varchar(50) not null,
  capacidad int not null,
  estado varchar(45) not null,
  PRIMARY KEY (id));
 
 create table if not exists Horario(
 id SERIAL,
 hora varchar(50) not null,
 primary KEY(id) 
 );
 
 create table if not exists Reserva (
 id SERIAL,
 recurso int references Recurso(id),
 usuario varchar(50) references Usuario(correo),
 fechainicio date not null,
 estado char(3) not null,
 franja_ini int references Horario(id),
 duracion int not null
 );

