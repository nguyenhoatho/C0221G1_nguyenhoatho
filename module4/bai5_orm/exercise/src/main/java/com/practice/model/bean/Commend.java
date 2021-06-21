package com.practice.model.bean;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table
public class Commend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short rating;
    private String author;
    private String message;
    @Column(name = "like_count",columnDefinition = "INT")
    private Integer likeCount;
    @Column(name = "date_now",columnDefinition = "DATE")
    private Date dateNow = new Date(System.currentTimeMillis());

    public Commend() {
    }


    public Commend(Short rating, String author, String message) {
        this.rating = rating;
        this.author = author;
        this.message = message;
    }

    public Commend(Short rating, String author, String message, Integer likeCount,Date dateNow) {
        this.rating = rating;
        this.author = author;
        this.message = message;
        this.likeCount = likeCount;
        this.dateNow = dateNow;

    }

    public Commend(Long id, Short rating, String author, String message, Integer likeCount,Date dateNow) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.message = message;
        this.likeCount = likeCount;
        this.dateNow = dateNow;


    }


    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", rating=" + rating +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                ", likeCount='" + likeCount + '\'' +
                '}';
    }
}
