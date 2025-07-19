package com.api.app.service;

import java.util.List;

import com.api.app.model.Post;

public interface PostService {

    // Define los métodos que serán implementados por la clase PostServiceImpl
    public List<Post> getAllPosts();

    Post getPostById(Long id);

  
}
