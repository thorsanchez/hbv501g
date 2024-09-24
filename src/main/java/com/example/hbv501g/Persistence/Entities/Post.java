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
    private long forum_id;
    private long user_id;


    public Post() {
    }

    public Post(String tag, String title, String content) {
        this.tag = tag;
        this.title = title;
        this.content = content;
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

    public long getForum_id() {
        return forum_id;
    }

    public void setForum_id(long forum_id) {
        this.forum_id = forum_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
