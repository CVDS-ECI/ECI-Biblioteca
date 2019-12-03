# Biblioteca ECI
## Proyecto final de CVDS (Ciclos de Vida Del Desarrollo de Software). Periodo 2019-2
## Escuela Colombiana de Ingeniería Julio Garavito

### Integrantes

+  Juan Sebastián Frásica Galeano
+  Andrés Felipe Marcelo
+  Santiago Rubiano
+  David Vargas

### Profesor
+ Julián-Velasco

## Descripción del producto

## Arquitectura y diseño detallado

### Modelo E-R (Entidad-Relación)
![ER](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/EntidadRelacion.png)

### Diagrama de paquetes
![Diagrama-de-clases-sprint-1-y-2](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/Diagrama_de_clases.png)

### Descripción de la arquitectura y tecnologías utilizadas
La aplicación está construida en 3 capas:

#### Capa de presentación
En esta capa se hizo uso de tecnologías como:
+  JSF-(Java-Server-Faces)
+  Primefaces

#### Capa de aplicación
Aquí se usaron tecnologías:
+  Java
+  Google Guice (Un framework para inyección de dependencias)
+  Maven (Herramienta para gestión de dependencias)
+  Apache Shiro (Framework para autentiticación)

#### Capa de persistencia de datos
Se usó un motor de bases de datos **PostgreSQL** y la herramienta **myBatis**, la cual se encarga de la persistencia (mappea sentencias SQL y procedimientos almacenados con objetos a partir de ficheros XML o anotaciones).

### Enlace de la aplicación en Heroku
http://ecibrary.herokuapp.com/

### Integración continua
[![CircleCI](https://circleci.com/gh/CVDS-ECI/ECI-Biblioteca.svg?style=svg)](https://circleci.com/gh/CVDS-ECI/ECI-Biblioteca)

### Calidad del código
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/64ad0e4484824d6ab2794f5535063e6f)](https://www.codacy.com/manual/sebastianfrasic/ECI-Biblioteca?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CVDS-ECI/ECI-Biblioteca&amp;utm_campaign=Badge_Grade)

## Descripción del proceso
Se trabajó mediante la metodología ágil Scrum. Durante todo el proceso se hicieron 3 sprints. Cada uno con una duración de 2 semanas.

## Descripción sprint 1

Burndown chart and backlog

+ Burndown chart: https://tree.taiga.io/project/sebastianfrasic-gestion-de-recursos-biblioteca/taskboard/sprint-1-15837

En este sprint se completaron casi todos los objetivos por realizar. Cada integrante del equipo cumplió con sus deberes en el tiempo adecuado y con una calidad óptima. La página de incio de sesión sirve correctamente y se puede realizar ciertas funciones dependiendo del usuario que inicie sesión. Faltó arreglar detalles como cambiar las vistas cuando se logea la comunidad y consultar un recurso. 

![Burndown chart and backlog sprint 1](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/BURNDOWN%20CHART%20AND%20BACKLOG%20SPRINT%201.png)

## Descripción sprint 2

Burndown chart and backlog

+ Burndown chart: https://tree.taiga.io/project/sebastianfrasic-gestion-de-recursos-biblioteca/taskboard/sprint-2-8608

En este sprint quedaron varias tareas abiertas/pendientes por hacer debido a que hubo problemas con el tiempo que cada integrante tuvo para realizar. Además de que tocó hacer una refactorización de la parte de UX y la mayoría de Front, en lo cual un integrante estuvo bastante desapegado con el trabajo que se tenía que hacer.
Las tareas que quedaron incompletas fueron las de reservar un recurso y la de ver el calendario con las reservas.
Acá también se corrigieron algunos issues del sprint 1.
![Burndown chart and backlog sprint 2](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/BURNDOWN%20CHART%20AND%20BACKLOG%20SPRINT%202.png)


## Descripción sprint 3

Burndown chart and backlog

+ Burndown chart: https://tree.taiga.io/project/sebastianfrasic-gestion-de-recursos-biblioteca/taskboard/sprint-3-5679

Finalmente, en este último sprint se completaron todas las tareas pendientes del segundo sprint, y se realizó correctamente el resto de tareas asignadas para este sprint.
Lo único que no se pudo hacer como lo pedían en el requisito fue lo de filtrar los reportes de ocupación y generar el archivo Excel.

Podría decirse que se cumplieron con todas las tareas solcitadas, y que el proyecto está en un excelente estado en cuanto a funcionalidad y calidad.

![Burndown chart and backlog sprint 3](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/BURNDOWN%20CHART%20AND%20BACKLOG%20SPRINT%203.PNG)




