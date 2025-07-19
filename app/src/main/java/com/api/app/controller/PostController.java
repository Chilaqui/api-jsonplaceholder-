package com.api.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.service.PostService;

@RestController// Controlador para manejar las peticiones relacionadas con los posts
@RequestMapping("api/posts")//Ruta base para los endpoints de posts
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping()// Endpoint para obtener todos los posts
    public ResponseEntity<?> getAllPost(){
        try {
            return ResponseEntity.ok(postService.getAllPosts());
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body("ErrorAl obtener los posts: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(postService.getPostById(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el post: " + e.getMessage());
        }
    }



}
