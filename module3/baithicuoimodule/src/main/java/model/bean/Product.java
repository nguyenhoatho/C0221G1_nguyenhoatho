package model.bean;

import java.util.Locale;

public class Product {
    private int productId;
    private String productName;
    private String productPrice;
    private String productAmount;
    private String productDescription;
    private Category categoryName;

    public Product(int productId, String productName, String productPrice, String productAmount, String productDescription, Category categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productDescription = productDescription;
        this.categoryName = categoryName;
    }

    public Product(int productID, String productName, String productPrice, String productAmout, String amout, String descriptionProduct, Category categoryName) {
    }



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }
}
