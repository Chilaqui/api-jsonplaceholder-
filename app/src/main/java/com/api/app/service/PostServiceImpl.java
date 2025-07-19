package com.api.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.app.client.PostApiClient;
import com.api.app.model.Post;

@Service
public class PostServiceImpl implements PostService {

    private final PostApiClient postApiClient;

    public PostServiceImpl(PostApiClient postApiClient){
        this.postApiClient = postApiClient;
    }

    @Override
    public List<Post> getAllPosts(){
        return postApiClient.fetchAllPosts();
    }


    @Override
    public Post getPostById(Long id){
        return postApiClient.fetchPostById(id);
    }


}
