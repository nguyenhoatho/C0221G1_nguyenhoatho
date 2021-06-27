package com.example.productmanagementsortingpaging.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProductDto {
    private Integer id;
    @NotEmpty(message = "Name không đc trống")
    private String nameProduct;
//    @NotEmpty(message = "không được rỗng")
    private double price;
    @NotEmpty(message = "Không đc trống")
    private String description;
    @NotEmpty(message = "Không đc trống")
    private String manufacture;

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
