package com.example.update.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String nameBlog;
    private String Author;
    private String tittle;
    private String content;
    @Column(columnDefinition = "DATETIME")
    private Date dayOfCreate;
    @ManyToOne
    @JoinColumn(name = "blog_id",referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "idUser")
    private User user;

    public Blog(Integer idBlog, String nameBlog, String author, String tittle, String content, Date dayOfCreate) {
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        Author = author;
        this.tittle = tittle;
        this.content = content;
        this.dayOfCreate = dayOfCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDayOfCreate() {
        return dayOfCreate;
    }

    public void setDayOfCreate(Date dayOfCreate) {
        this.dayOfCreate = dayOfCreate;
    }
}
