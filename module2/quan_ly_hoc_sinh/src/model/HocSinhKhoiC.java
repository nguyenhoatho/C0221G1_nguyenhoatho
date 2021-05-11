package model;

public class HocSinhKhoiC extends HocSinh {
    private String van;
    private String su;
    private String dia;

    public HocSinhKhoiC(String soBaoDanh, String hoTen, String diachi, String uuTien, String van, String su, String dia) {
        super(soBaoDanh, hoTen, diachi, uuTien);
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    public HocSinhKhoiC() {
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return super.toString()+","+van+","+su+","+dia;
    }

    @Override
    public String showInfor() {
       return  "so bao danh "+super.getSoBaoDanh()+"\t ho va ten "+super.getHoTen()+"\t dia chi"+super.getDiachi()
                +"khu vuc uu tien"+super.getUuTien()+"\tmon van"+van+"\tmon su"+su+"\t mon dia"+dia;
    }
}
