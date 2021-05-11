package model;

public class HocSinhKhoiB extends HocSinh {
    private String toan;
    private String hoa;
    private String sinh;

    public HocSinhKhoiB(String soBaoDanh, String hoTen, String diachi, String uuTien, String toan, String hoa, String sinh) {
        super(soBaoDanh, hoTen, diachi, uuTien);
        this.toan = toan;
        this.hoa = hoa;
        this.sinh = sinh;
    }

    public HocSinhKhoiB() {
    }

    @Override
    public String toString() {
        return super.toString()+","+toan+","+hoa+","+sinh;
    }

    @Override
    public String showInfor() {
      return   "so bao danh "+super.getSoBaoDanh()+"\t ho va ten "+super.getHoTen()+"\t dia chi"+super.getDiachi()
                +"khu vuc uu tien"+super.getUuTien()+"\t mon toan"+toan+"\tmon hoa"+hoa+"\t mon sinh"+sinh;
    }
}
