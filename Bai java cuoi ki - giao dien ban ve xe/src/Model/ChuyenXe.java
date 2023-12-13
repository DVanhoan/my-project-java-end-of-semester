package Model;

public class ChuyenXe {
    private int maChuyenXe;
    private String diemDi;
    private String diemDen;
    private String ngayKhoiHanh;
    private int SoVeDaBan;

    public ChuyenXe() {
        super();
    }

    public ChuyenXe(int maChuyenXe, String diemDi, String diemDen, String ngayKhoiHanh, int soVeDaBan) {
        super();
        this.maChuyenXe = maChuyenXe;
        this.diemDi = diemDi;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        SoVeDaBan = soVeDaBan;
    }

    public int getMaChuyenXe() {
        return maChuyenXe;
    }

    public void setMaChuyenXe(int maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public int getSoVeDaBan() {
        return SoVeDaBan;
    }

    public void setSoVeDaBan(int soVeDaBan) {
        SoVeDaBan = soVeDaBan;
    }
}
