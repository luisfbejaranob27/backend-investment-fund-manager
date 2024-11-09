# Backend Investment Fund Manager

Es una plataforma para clientes de BTG Pactual que les permita manejar sus fondos de inversión de manera independiente y sin la necesidad de asistencia comercial directa de una manera intuitiva, amigable.

## Características

- Spring Boot 3
- Arquitectura Hexagonal
- MongoDB
- Manejo de Excepciones
- Sistema de registro de logs

## Requisitos

Para poder ejecutar este proyecto, necesitas:

- **Java 17** o superior
- **Gradle 7.0** o superior

## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/luisfbejaranob27/backend-investment-fund-manager
   cd backend-investment-fund-manager
   ```

2. Asegúrate de tener las dependencias necesarias ejecutando:

   ```bash
   ./gradlew build

## Configuración

### Configuración de la base de datos

En el archivo `src/main/resources/application.properties` o `application.yml`, configura los detalles de conexión a la base de datos:

```properties
#MongoDB
spring.data.mongodb.host = localhost
spring.data.mongodb.port = 27017
spring.data.mongodb.database = investment-fund-manager
```
> Cambia estos valores según tu configuración.

### Variables de Entorno

Para ciertas configuraciones sensibles (como claves de API o configuraciones de autenticación), es recomendable usar variables de entorno o un archivo `.env`.

## Ejecución del Proyecto

Para ejecutar el proyecto localmente, usa el siguiente comando:

```bash
./gradlew bootRun
```

La aplicación estará disponible en `http://localhost:8080`.

## API Endpoints

### Client

| Método | Endpoint          | Descripción                   |
|--------|-------------------|-------------------------------|
| GET    | /api/clients      | Listado de todos los clientes |
| POST   | /api/clients      | Crear un nuevo cliente        |
| GET    | /api/clients/{id} | Obtener cliente por Id        |
| PUT    | /api/clients/{id} | Actualizar cliente por Id     |
| DELETE | /api/clients/{id} | Eliminar cliente por Id       |

### Fund

| Método | Endpoint             | Descripción                 |
|--------|----------------------|-----------------------------|
| GET    | /api/funds           | Listado de todos los fondos |
| POST   | /api/funds           | Crear un nuevo fondo        |
| GET    | /api/funds/{id}      | Obtener fondo por Id        |
| GET    | /api/funds/name/{id} | Obtener fondo por Nombre    |
| PUT    | /api/funds/{id}      | Actualizar cliente por Id   |
| DELETE | /api/funds/{id}      | Eliminar cliente por Id     |

### Transaction

| Método | Endpoint              | Descripción                                     |
|--------|-----------------------|-------------------------------------------------|
| GET    | /api/transactions     | Listado de todas las transacciones              |
| POST   | /api/funds            | Crear una nueva transaccions                    |
| GET    | /api/funds/{clientId} | Listado de todas las transacciones por clientId |

## Pruebas

Para ejecutar las pruebas, utiliza el siguiente comando:

```bash
./gradlew test
```

## Tecnologías Utilizadas

- **Spring Boot** - Framework principal
- **Mongo Repository** - Para la persistencia de datos
- **MongoDB** - Base de datos

