# Desafio BCI

Este proyecto es una aplicación API REST creada con Java, Spring Boot, y Gradle. Utiliza la base de datos en memoria H2.

## Requisitos

- Java JDK 17 o superior
- Gradle
- Spring Boot

## Clonar el repositorio

Para obtener el proyecto, deberás clonarlo a tu máquina local utilizando git. Si no tienes git instalado, puedes descargarlo [aquí](https://git-scm.com/downloads).

Abre tu terminal y ejecuta el siguiente comando:

```bash
git clone https://github.com/chep88/user.git
```

## Configuración

El proyecto utiliza la base de datos en memoria H2. La configuración de la base de datos se encuentra en el archivo `application.properties` ubicado en el directorio `/src/main/resources`.

```properties
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.datasource.url=jdbc:h2:file:./data/demo;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
server.port=8090
spring.datasource.username=sa
spring.datasource.password=
```

Si prefieres usar otra base de datos, puedes cambiar estas configuraciones.

## Construcción y Ejecución del Proyecto

Abre tu terminal y navega al directorio del proyecto clonado. Una vez allí, puedes construir el proyecto utilizando Gradle. Ejecuta el siguiente comando:

```bash
./gradlew build
```

Este comando generará un archivo JAR en el directorio `/build/libs`.

Para ejecutar la aplicación, ejecuta el siguiente comando:

```bash
java -jar build/libs/user-0.0.1.jar
```

Donde `user-0.0.1.jar` es el nombre del archivo JAR generado por la construcción del proyecto.

## Endpoints

La aplicación tiene un CRUD de usuarios. Aquí están los endpoints disponibles:

- Crear usuario: `POST /api/usuarios`
- Leer todos los usuarios: `GET /api/usuarios`
- Leer un usuario por ID: `GET /api/usuarios/{id}`
- Actualizar un usuario por ID: `PUT /api/usuarios/{id}`