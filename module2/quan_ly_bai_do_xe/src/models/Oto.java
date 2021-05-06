package models;

public class Oto extends BoCongAn {
    private int soKieuNgoi;
    private String kieuXe;

    public Oto(String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, int soKieuNgoi, String kieuXe) {
        super(bienKiemSoat, hangSanXuat, namSanxuat, chuSoHuu);
        this.soKieuNgoi = soKieuNgoi;
        this.kieuXe = kieuXe;
    }

    public Oto() {
    }

    public int getSoKieuNgoi() {
        return soKieuNgoi;
    }

    public void setSoKieuNgoi(int soKieuNgoi) {
        this.soKieuNgoi = soKieuNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return super.toString()+","+ soKieuNgoi +","+ kieuXe;
    }

}
