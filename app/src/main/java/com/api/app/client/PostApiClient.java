package com.api.app.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.api.app.model.Post;

@Component
public class PostApiClient {//Clase que se encarga de hacer las peticiones a la API de posts

    private final WebClient webClient;

    //Inyecta el WebClient configurado en WebClientConfig
    public PostApiClient(WebClient webClient){
        this.webClient = webClient;
    }

    //Metodo que obtiene todos los posts de la API
    public List<Post> fetchAllPosts(){
        return webClient.get() 
                .uri("/posts")//Especifica la URI de la API
                .retrieve()//Realiza la solicitud GET a la API
                .bodyToFlux(Post.class)//Convierte la respuesta en un flujo reactivo
                .collectList()//Lo convierte en una lista
                .block(); //Bloquea hasta que se complete la solicitud y devuelve la lista de posts
    }

    public Post fetchPostById(Long id){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/posts/{id}").build(id)) // Especifica la URI con el ID del post solo cuando desea obtener un post específico
                .retrieve()
                .bodyToMono(Post.class) // Convierte la respuesta en un Mono de Post
                .block(); // Bloquea hasta que se complete la solicitud y devuelve el Post
    }


}
