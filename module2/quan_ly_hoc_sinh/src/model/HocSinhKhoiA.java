package model;

public class HocSinhKhoiA extends HocSinh {
    private String monToan;
    private String monLy;
    private String monHoa;

    public String getMonToan() {
        return monToan;
    }

    public void setMonToan(String monToan) {
        this.monToan = monToan;
    }

    public String getMonLy() {
        return monLy;
    }

    public void setMonLy(String monLy) {
        this.monLy = monLy;
    }

    public String getMonHoa() {
        return monHoa;
    }

    public void setMonHoa(String monHoa) {
        this.monHoa = monHoa;
    }

    public HocSinhKhoiA(String soBaoDanh, String hoTen, String diachi, String uuTien, String monToan, String monLy, String monHoa) {
        super(soBaoDanh, hoTen, diachi, uuTien);
        this.monToan = monToan;
        this.monLy = monLy;
        this.monHoa = monHoa;
    }

    public HocSinhKhoiA() {
    }

    @Override
    public String toString() {
        return super.toString()+","+monToan+","+monLy+","+monToan;
    }

    @Override
    public String showInfor() {
        return "so bao danh "+super.getSoBaoDanh()+"\t ho va ten "+super.getHoTen()+"\t dia chi"+super.getDiachi()
                +"khu vuc uu tien"+super.getUuTien()+
                "monToan='" + monToan + '\'' +
                ", monLy='" + monLy + '\'' +
                ", monHoa='" + monHoa + '\'' +
                '}';
    }
}
