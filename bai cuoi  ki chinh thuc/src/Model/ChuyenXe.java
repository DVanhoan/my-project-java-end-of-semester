package Model;

public class ChuyenXe {
    private String MaChuyenXe;
    private String DiemDi;
    private String DiemDen;
    private String NgayKhoiHanh;
    private float giaVe;
    private int soLuongVe;

    public ChuyenXe() {
        super();
    }

    public ChuyenXe(String maChuyenXe, String diemDi, String diemDen, String ngayKhoiHanh, float giaVe, int soLuongVe) {
        super();
        MaChuyenXe = maChuyenXe;
        DiemDi = diemDi;
        DiemDen = diemDen;
        NgayKhoiHanh = ngayKhoiHanh;
        giaVe = giaVe;
        soLuongVe = soLuongVe;
    }

    public String getMaChuyenXe() {
        return MaChuyenXe;
    }

    public void setMaChuyenXe(String maChuyenXe) {
        MaChuyenXe = maChuyenXe;
    }

    public String getDiemDi() {
        return DiemDi;
    }

    public void setDiemDi(String diemDi) {
        DiemDi = diemDi;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String diemDen) {
        DiemDen = diemDen;
    }

    public String getNgayKhoiHanh() {
        return NgayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        NgayKhoiHanh = ngayKhoiHanh;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }
}
