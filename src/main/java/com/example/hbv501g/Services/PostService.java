package com.example.hbv501g.Services;

import com.example.hbv501g.Persistence.Entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    Post findByTitle(String title);
    Post findByID(long ID);
    List<Post> findAll();
    Post save(Post post);
    void delete(Post post);
}
