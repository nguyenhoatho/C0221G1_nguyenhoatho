package models;

public class Xetai extends BoCongAn {
    private double trongtai;

    public Xetai(String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, double trongtai) {
        super(bienKiemSoat, hangSanXuat, namSanxuat, chuSoHuu);
        this.trongtai = trongtai;
    }

    public Xetai(double trongtai) {
        this.trongtai = trongtai;
    }

    public Xetai() {
    }

    public double getTrongtai() {
        return trongtai;
    }

    public void setTrongtai(double trongtai) {
        this.trongtai = trongtai;
    }

    @Override
    public String toString() {
        return super.toString()+","+ trongtai;
    }
}
