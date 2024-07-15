
# ForoHub

ForoHub es una aplicación de foro construida con Java y Spring Boot. Esta API REST permite crear, listar, actualizar y eliminar tópicos en un foro. La base de datos utilizada es MySQL, y la seguridad se implementa con JWT.

## Requisitos

- Java 11 o superior
- Maven
- MySQL
- IntelliJ IDEA (opcional, pero recomendado)

## Configuración del Entorno

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/tu-usuario/forohub.git
   cd forohub
   ```

2. **Configurar la base de datos:**

   Crea una base de datos en MySQL llamada `forohub`:

   ```sql
   CREATE DATABASE forohub;
   ```

   Asegúrate de tener un usuario con los permisos necesarios para acceder a esta base de datos.

3. **Configurar propiedades de la aplicación:**

   Edita el archivo `src/main/resources/application.properties` para incluir tus credenciales de MySQL:

   ```properties
spring.datasource.url=jdbc:mysql://localhost/forohub
spring.datasource.username=nombre_de_usuario
spring.datasource.password=contraseña_de_usuario
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

4. **Compilar y ejecutar la aplicación:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Estructura del Proyecto

El proyecto sigue una estructura típica de Spring Boot:

```
src/main/java/com/alura/forohub
|-- config
|   |-- SecurityConfig.java
|-- controller
|   |-- TopicController.java
|-- dto
|   |-- TopicDto.java
|-- model
|   |-- Topic.java
|   |-- User.java
|-- repository
|   |-- TopicRepository.java
|-- service
|   |-- TopicService.java
|-- ForoHubApplication.java

src/main/resources
|-- application.properties
|-- db/migration
|   |-- V1__create_tables.sql
```




## Migraciones de Base de Datos

Las migraciones de la base de datos se manejan con Flyway en el directorio `src/main/resources/db/migration` con el archivo `V1__create_tables.sql` que tiene las instrucciones para crear las tablas necesarias.



## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarme a través de mi correo electrónico: [e-calderonm@hotmail.com](mailto:e-calderonm@hotmail.com).

---

¡Gracias por usar ForoHub!
```

