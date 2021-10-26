# Meli Show API

Meli Show es una api que expone los endpoints necesarios para listar todos los shows, realizar busquedas avanzadas, listar las butacas disponibles para una función especifica y por último, reservar una butaca para una función.
Para el desarrollo se utilizaron las siguientes tecnologias:
- Java 8
- Springboot 
- Hibernate
- H2 DataBase
- Lombok plugin
- Log4j plugin
- EntityMapper plugin
- Junit

## Instalacion

#### 1- Clonar el proyecto:
```
git clone git@github.com:fedevara/meli.shows.git
```
#### 2- Descargar h2 connector:
```
https://www.h2database.com/html/download.html
```
#### 3- Asegurarse de tener java 8 o superior instalado
```
https://www.java.com/es/download/ie_manual.jsp
```
#### 4- Ejecutar clean install sobre el proyecto maven

## Ejecucion

#### 1- Iniciar la consola de h2
#### 2- Ejecutar la aplicacion desde el main menu: clase Application

## Endpoints

> [Postman Collection](https://www.getpostman.com/collections/91d74790c779d57935d4)

### Busca todos los shows
``` HTTP
GET /shows/buscar-shows
```

---
### Busqueda avanzada de los shows
``` HTTP
GET /shows/busqueda-avanzada-shows?
```
---
### Listar las butacas disponibles para la funcion de un show
``` HTTP
GET /shows/listar-butacas-disponibles?funcion_id=FUNCION_ID?show_id=:SHOW_ID
```
---
### Reservar una butaca para una funcion
``` HTTP
POST /shows/reservar-butaca
```
#### Body Request
```JSON
{
    "funcion": 1,
    "nombre": "Fede Vara",
    "documento": 12345,
    "butaca": 1,
    "precio": 200.0
}
```
