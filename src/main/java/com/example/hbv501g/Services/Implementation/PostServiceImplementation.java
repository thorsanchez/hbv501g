package com.example.hbv501g.Services.Implementation;

import com.example.hbv501g.Persistence.Entities.Post;
import com.example.hbv501g.Persistence.Repositories.PostRepository;
import com.example.hbv501g.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    private PostRepository postRepository;
    @Autowired
    public PostServiceImplementation(PostRepository postRepository) {
       this.postRepository = postRepository;
    }


    @Override
    public Post findByTitle(String title) {
       return postRepository.findByTitle(title).get(0);
    }

    @Override
    public Post findByID(long ID) {
        return postRepository.findbyID(ID);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
