package com.example.update.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    @OneToMany(mappedBy = "category", cascade =CascadeType.ALL)
    private List<Blog> blogList;

    public Category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;

    }

    public Category() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
