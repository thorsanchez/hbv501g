package com.example.hbv501g.Persistence.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;

    private String tag;
    private String title;
    private String content;
    private double timestamp;

    @ManyToOne
   // @JoinColumn(name = "forum_id", nullable = false)
    private Forum forum;

    @ManyToOne
    //@JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Post() {
    }

    public Post(String tag, String title, String content, Forum forum, User user) {
        this.tag = tag;
        this.title = title;
        this.content = content;
        this.forum = forum;
        this.user = user;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
