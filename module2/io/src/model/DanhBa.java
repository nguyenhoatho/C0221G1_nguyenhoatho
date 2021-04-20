package model;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private String ten;
    private String phone;
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public DanhBa(String ten, String phone) {
        super();
        this.ten = ten;
        this.phone = phone;
    }
    public DanhBa() {
        super();
    }
    public String toString() {
        return this.ten+"\t"+this.phone;
    }
}

