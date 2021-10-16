package aptech.project2.nhom2.model;

public class DataTimKiem {
    private String tenSach;
    private String tacGia;
    private String danhMuc;
    private String nhaXuatBan;

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public DataTimKiem(String tenSach, String tacGia, String danhMuc, String nhaXuatBan) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.danhMuc = danhMuc;
        this.nhaXuatBan = nhaXuatBan;
    }

    @Override
    public String toString() {
        return "DataTinKiem [danhMuc=" + danhMuc + ", nhaXuatBan=" + nhaXuatBan + ", tacGia=" + tacGia + ", tenSach="
                + tenSach + "]";
    }

}
