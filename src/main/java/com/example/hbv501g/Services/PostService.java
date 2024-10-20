package com.example.hbv501g.Services;

import com.example.hbv501g.Persistence.Entities.Forum;
import com.example.hbv501g.Persistence.Entities.Post;

import java.util.List;

public interface PostService {
    Post findByTitle(String title);
    Post findById(long ID);
    List<Post> findAll();
    Post save(Post post);
    void delete(Post post);
    List<Post> getPostByForum(Forum forum);
}
