package com.example.hbv501g.Persistence.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "forums")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long forum_id;
    private String name;
    private String description;
    private String category;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> forumPosts;

    //tengja forum við User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    public List<Post> getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(List<Post> forumPosts) {
        this.forumPosts = forumPosts;
    }

    public Forum() {
    }

    public Forum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getForum_id() {
        return forum_id;
    }

    public void setForum_id(long forum_id) {
        this.forum_id = forum_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
