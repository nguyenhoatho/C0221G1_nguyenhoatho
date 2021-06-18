package excercise.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Product {
    private String nameProduct;
    private int idProduct;
    private double priceProduct;

    public Product(String nameProduct, int idProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.priceProduct = priceProduct;
    }

    public Product() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

}
