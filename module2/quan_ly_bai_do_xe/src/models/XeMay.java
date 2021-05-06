package models;

public class XeMay extends BoCongAn {
    private String congSuat;

    public XeMay(String bienKiemSoat, String hangSanXuat, String namSanxuat, String chuSoHuu, String congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanxuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public XeMay() {
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return super.toString()+","+congSuat ;
    }
}
