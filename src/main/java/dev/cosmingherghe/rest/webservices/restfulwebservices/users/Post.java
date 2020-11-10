package dev.cosmingherghe.rest.webservices.restfulwebservices.users;

import java.util.Date;

public class Post {

    private Integer id;
    private Integer userId;
    private Date date;
    private String post;

    public Post(Integer id, Integer userId, String post) {
        this.id = id;
        this.userId = userId;
        this.post = post;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", post='" + post +
                '}';
    }
}