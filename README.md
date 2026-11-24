# api-oportunidades

Microservicio REST en **Spring Boot** para el CRUD de oportunidades de la app móvil *Gestión de oportunidades y activaciones corporativas* (DSY1105, Caso 007D).

## Tecnologías
- Java 21 · Spring Boot · Spring Web MVC · Spring Data JPA (Hibernate) · Lombok
- Base de datos: **MySQL** (perfil por defecto) o **H2** en archivo (perfil `h2`)

## Estructura
```
controller/   OportunidadController  → endpoints REST
service/      OportunidadService     → lógica de negocio y transacciones
repository/   OportunidadRepository  → JpaRepository (acceso a datos)
model/        Oportunidad            → entidad JPA (tabla "oportunidades")
```

## Endpoints – base `http://localhost:8080`

| Método | Endpoint | Respuesta |
|---|---|---|
| GET | `/api/oportunidades` | 200 + lista (orden id DESC) |
| GET | `/api/oportunidades/{id}` | 200 o 404 |
| POST | `/api/oportunidades` | 201 + oportunidad creada |
| PUT | `/api/oportunidades/{id}` | 200 o 404 |
| DELETE | `/api/oportunidades/{id}` | 204 o 404 |

Ejemplo de cuerpo (POST/PUT):
```json
{
  "nombre": "Feria Costanera",
  "tipo": "Feria empresarial",
  "descripcion": "Activación en feria navideña",
  "fuente": "Web",
  "prioridad": "Alta",
  "potencial": "Alto",
  "estado": "Evento identificado",
  "observaciones": ""
}
```

## Cómo ejecutar
```powershell
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"   # o cualquier JDK 21+

# Opción A: H2 (no requiere instalar nada; datos en ./data)
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=h2"

# Opción B: MySQL (XAMPP encendido en el puerto 3306; la BD se crea sola)
.\mvnw.cmd spring-boot:run
```
El servidor escucha en `0.0.0.0:8080`, así que el emulador Android lo alcanza en `http://10.0.2.2:8080/`.

## Integrantes
- Martin Jaque
- Liza Micele
