# 📡 API JSONPlaceholder Client - Spring Boot

Este proyecto es una aplicación backend construida con **Spring Boot** que consume la API pública de [JSONPlaceholder](https://jsonplaceholder.typicode.com/) usando **WebClient** de forma reactiva.

Proporciona endpoints REST para consultar **posts** desde un cliente externo, encapsulando la lógica en una arquitectura limpia de tipo `Controller → Service → Client`.

---

## 🚀 Características

- Consume datos de `https://jsonplaceholder.typicode.com/posts`
- Utiliza `WebClient` con configuración centralizada
- Arquitectura en capas:
  - `Controller`: maneja peticiones externas
  - `Service`: orquesta la lógica de negocio
  - `Client`: se conecta con la API externa
- Manejo de errores con `ResponseEntity`
- Probado con `curl`

---

## 🧩 Estructura del Proyecto
```yaml
src/
├── controller/
│ └── PostController.java
├── service/
│ ├── PostService.java
│ └── PostServiceImpl.java
├── client/
│ └── PostApiClient.java
├── model/
│ └── Post.java
├── conf/
│ └── WebClientConfig.java
```

---

## ⚙️ Dependencias

- Java 17+
- Spring Boot
- Spring WebFlux (para WebClient)

---

## 🔧 Configuración del WebClient

```java
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
    }
}
```
## 📡 Endpoints disponibles
- Método	URL	Descripción
- GET	/api/posts	Devuelve todos los posts
- GET	/api/posts/{id}	Devuelve un post específico por ID

## 🧪 Pruebas con curl

- Obtener todos los posts

```bash

curl -X GET http://localhost:8080/api/posts

```

- Obtener un post por ID

```bash
curl -X GET http://localhost:8080/api/posts/1
```

- Respuesta esperada:

```bash
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit..."
}

```
## 📌 Notas adicionales

- En caso de error, la API responde con un mensaje en el cuerpo:

```bash
{
  "error": "Error al obtener los posts: ..."
}
```

- El método .block() es usado para convertir el flujo reactivo a una lista sincrónica (ideal para este tipo de ejemplos).

## 📦 Ejecutar el proyecto
- Clona el repositorio

- Asegúrate de tener Java 17 y Maven instalados

- Ejecuta:

```bash
./mvnw spring-boot:run

```
- Accede a: http://localhost:8080/api/posts

📚 Licencia
Este proyecto es solo para fines educativos. Puedes modificarlo libremente.