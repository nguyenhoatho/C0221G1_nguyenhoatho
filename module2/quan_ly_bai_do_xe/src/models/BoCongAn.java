package models;

public abstract class BoCongAn {
    private String bienKiemSoat;
    private String hangSanXuat;
    private String namSanxuat;
    private String chuSoHuu;

    public BoCongAn(String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hangSanXuat = hangSanXuat;
        this.namSanxuat = namSanxuat;
        this.chuSoHuu = chuSoHuu;
    }

    public BoCongAn() {
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getNamSanxuat() {
        return namSanxuat;
    }

    public void setNamSanxuat(String namSanxuat) {
        this.namSanxuat = namSanxuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return
                 bienKiemSoat +","+hangSanXuat + ","
                 + namSanxuat +","
                 + chuSoHuu ;
    }
}
