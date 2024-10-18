package com.example.hbv501g.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;

    private String tag;
    private String title;
    private String content;
    // private Date timestamp;

    //likes og dislike
    private int likes = 0;
    private int dislikes = 0;

    @ManyToOne
    @JoinColumn(name = "forum_forum_id", nullable = false)
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;
    
    public Post() {
    }

    public Post(String tag, String title, String content, Forum forum, User user) {
        this.tag = tag;
        this.title = title;
        this.content = content;
        this.forum = forum;
        this.user = user;
        this.likes = 0;
        this.dislikes = 0;
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

    // public Date getTimestamp() {
    //    return timestamp;
    // }

    //public void setTimestamp(Date timestamp) {
    //     this.timestamp = timestamp;
    //  }

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


    @Override
    public String toString() {
        return "Post{" +
                "id=" + post_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    // Við verðum að finna betri system fyrir likes:
    // 1. Það ætti ekki að vega hægt að sami user like-i eða dislike-i post tvisvar
    // 2. Það ætti ekki að vera hægt að sami user like-i og dislike-i post á sama tíma
    // 3. 'setLikes' og 'setDislikes' gæti farið mjög illa úrskeiðis; kannski skipta út fyrir 'userLikes', 'userUnLikes', o.s.fv.

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

}
