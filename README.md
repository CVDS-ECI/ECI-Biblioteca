# Biblioteca ECI
## Proyecto final de CVDS (Ciclos de Vida Del Desarrollo de Software). Periodo 2019-2
## Escuela Colombiana de Ingeniería Julio Garavito

### Integrantes
*  *Juan sebastián Frásica G*
*  *Andrés Felipe Marcelo*
*  *Santiago Rubiano*
*  *David Vargas*

### Profesor:
* Julián Velasco


## Descripción del producto

## Arquitectura y diseño detallado

### Modelo E-R (Entidad-Relación)
![ER](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/EntidadRelacion.png)

### Diagrama de clases
![Diagrama-de-clases-sprint-1-y-2](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/Diagrama_de_clases.png)

### Descripción de la arquitectura y tecnologías utilizadas
La aplicación está construida en 3 capas:
#### Capa de presentación
En esta capa se hizo uso de tecnologías como:
* JSF (Java Server Faces)
* Primefaces


#### Capa de aplicación
Aquí se usaron tecnologías:
* Java
* Google Guice (Un framework para inyección de dependencias)
* Maven (Herramienta para gestión de dependencias)
* Apache Shiro (Framework para autentiticación)

#### Capa de persistencia de datos
Se usó un motor de bases de datos **PostgreSQL** y la herramienta **myBatis**, la cual se encarga de la persistencia (mappea sentencias SQL y procedimientos almacenados con objetos a partir de ficheros XML o anotaciones).

### Enlace de la aplicación en Heroku
http://ecibrary.herokuapp.com/faces/login.xhtml

### Integración continua
[![CircleCI](https://circleci.com/gh/CVDS-ECI/ECI-Biblioteca.svg?style=svg)](https://circleci.com/gh/CVDS-ECI/ECI-Biblioteca)

### Calidad del código
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/64ad0e4484824d6ab2794f5535063e6f)](https://www.codacy.com/manual/sebastianfrasic/ECI-Biblioteca?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CVDS-ECI/ECI-Biblioteca&amp;utm_campaign=Badge_Grade)

## Descripción del proceso
Se trabajó mediante la metodología ágil Scrum. Durante todo el proceso se hicieron 3 sprints. Cada uno con una duración de 2 semanas.

## Descripción sprint 1

Burndown chart and backlog

* Backlog: https://tree.taiga.io/project/sebastianfrasic-gestion-de-recursos-biblioteca/backlog
* Burndown chart: https://tree.taiga.io/project/sebastianfrasic-gestion-de-recursos-biblioteca/taskboard/sprint-1-15837

![Burndown chart and backlog sprint 1](https://github.com/CVDS-ECI/ECI-Biblioteca/blob/master/img/BURNDOWN%20CHART%20AND%20BACKLOG%20SPRINT%201.png)


