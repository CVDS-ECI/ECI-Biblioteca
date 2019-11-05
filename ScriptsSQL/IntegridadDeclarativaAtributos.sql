ALTER TABLE recurso ADD constraint CK_RECURSO_CAPACIDAD CHECK (capacidad > 0);
ALTER TABLE recurso ADD constraint CK_RECURSO_TIPO CHECK (tipo in ('Sala', 'Equipo de computo','Equipo de multimedia','Libro'));
ALTER TABLE recurso ADD constraint CK_RECURSO_ESTADO CHECK (estado in ('Disponible', 'En Mantenimiento','No Disponible'));
ALTER TABLE recurso ADD constraint CK_RECURSO_UBICACION CHECK (ubicacion in ('Biblioteca JAL Bloque B', 'Biblioteca JAL Bloque G'));
ALTER TABLE recurso ADD constraint CK_RECURSO_NOMBRE CHECK (nombre not in (' ', ''));

