
# API de libros y autores creada en SpringBoot JAVA implementando seguridad de JWT Token

Api desde cero creada con JAVA  y SpringBoot implementando seguridad usando Bcrypt y JWT con spring security


## Utilizaremos [SPRING INITALITZER](https://start.spring.io/)

utilizaremos para nuestro proyecto las siguientes dependencias de SpringBoot.

 - [Spring Boot DevTools](https://mvnrepository.com/artifact/mysql/mysql-connector-java)
 - [Lombok ](https://projectlombok.org/setup/maven)
  - [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
 - [Validation  ](https://mvnrepository.com/artifact/javax.validation/validation-api)
  - [Spring Data JPA](https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa)
 - [MySQL Driver ](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
  - [Spring Security](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core) 

## Referencias de API

#### Traer todos los libros

```http
  GET /libro/mostrar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `token api` | `string` | **Required**. apiToken |

#### Traer solo un libro

```http
  GET /libro/unidad/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `id`      | `string` | **Required**. id de libro y apiToken|


#### Crear un libro

```http
  POST /libro/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `titulo`      | `string` | **Required**  |
| `idioma`      | `string` | **Required**  |
| `autor`      | `json` | **Required**  |
| `nombre`      | `string` | **Required**  |
| `nacionalidad`      | `string` | **Required**  |

#### Actualizar un libro


```http
  PUT /libro/actualizar/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `titulo`      | `string` | **NotRequired**  |
| `idioma`      | `string` | **NotRequired**  |
| `autor`      | `json` | **NotRequired**  |
| `nombre`      | `string` | **NotRequired**  |
| `nacionalidad`      | `string` | **NotRequired**  |

#### Eliminar un libro

```http
  DELETE /borrar/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `token api` | `string` | **Required**. apiToken |
| `id`      | `Long` | **Required**  |


#### con la opcion de borrar solo lo ocultaremos del resto para tener una base de datos mas completa...........con nestra opcion de mostrar solo nos muestra los libros que no an sido ocultados 


## Seguridad
Para la seguridad creamos primero nuestros usuarios y claves, encriptamos primero nuestra clave con - [BCRYPT](https://bcrypt-generator.com/) y la guardamos en nuestra base de datos.

Tambien usaremos en JSON Web Token usaremos la version 4.2.4 - [JWT](https://jwt.io/) para enviar un token en nuestra cabecera de autenticacion a todos nuestos endPoint.



## Documentation

[JWT token](https://jwt.io/introduction) Para generar el token de autenticacion en todos nuestro endPoint,

[Bcrypt](https://www.npmjs.com/package/bcrypt) Para encriptar nuestras contrase;as en nuestra base de datos

[SpringInizialitzer](https://github.com/spring-io/initializr/) Donde encontraremos todas las dependencias necesarias para nuestro proyecto

[Maven properties](https://books.sonatype.com/mvnref-book/reference/resource-filtering-sect-properties.html) Aca podremos ayar mas informacion de las propiedades de maven



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=r)](https://portafolio-reack.vercel.app/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/edwin-castro-13a763272)




![edLogo](https://i.pinimg.com/736x/79/af/8d/79af8d9946ab024aeff1d9d6929af8a0.jpg)

