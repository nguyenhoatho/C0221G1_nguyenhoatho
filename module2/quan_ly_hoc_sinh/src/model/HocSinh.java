package model;

public abstract class HocSinh {
    private String soBaoDanh;
    private String hoTen;
    private String diachi;
    private String uuTien;

    public HocSinh(String soBaoDanh, String hoTen, String diachi, String uuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diachi = diachi;
        this.uuTien = uuTien;
    }

    public HocSinh() {
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public void setSoBaoDanh(String soBaoDanh) {
        this.soBaoDanh = soBaoDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getUuTien() {
        return uuTien;
    }

    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }

    @Override
    public String toString() {
        return  soBaoDanh + "," + hoTen + "," + diachi + "," + uuTien ;

    }
    public  abstract String  showInfor();
}
