package models;

public class DanhBa {
    private String soDienThoai;
    private String nhomCuaDanhBa;
    private String hoTen;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String email;

    public DanhBa(String soDienThoai, String nhomCuaDanhBa, String hoTen, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.soDienThoai = soDienThoai;
        this.nhomCuaDanhBa = nhomCuaDanhBa;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public DanhBa() {
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhomCuaDanhBa() {
        return nhomCuaDanhBa;
    }

    public void setNhomCuaDanhBa(String nhomCuaDanhBa) {
        this.nhomCuaDanhBa = nhomCuaDanhBa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return soDienThoai + "," + nhomCuaDanhBa + "," + hoTen + "," + gioiTinh + "," + "," + diaChi + "," + ngaySinh + "," +
                email;
    }

    public String hienThi() {
        return "DanhBa{" +
                "soDienThoai='" + soDienThoai + '\'' +
                ", nhomCuaDanhBa='" + nhomCuaDanhBa + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
