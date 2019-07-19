package com.ygor.javahibernate.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.ygor.javahibernate.model.Comment;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Timestamp created_on;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<Comment>();

    public Post() {}

    public Post(String title, String content, Timestamp created_on) {
        this.title = title;
        this.content = content;
        this.created_on = created_on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getCreatedOn() {
        return created_on;
    }

    public void setCreatedOn(Timestamp created_on) {
        this.created_on = created_on;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
