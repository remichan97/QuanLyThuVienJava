package aptech.project2.nhom2.model;

public class DataTimKiem {
    private String tenSach;
    private Integer tacGia;
    private Integer danhMuc;
    private Integer nhaXuatBan;

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public Integer getTacGia() {
        return tacGia;
    }

    public void setTacGia(Integer tacGia) {
        this.tacGia = tacGia;
    }

    public Integer getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Integer danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Integer getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(Integer nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public DataTimKiem(String tenSach, Integer tacGia, Integer danhMuc, Integer nhaXuatBan) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.danhMuc = danhMuc;
        this.nhaXuatBan = nhaXuatBan;
    }

    @Override
    public String toString() {
        return "DataTimKiem [danhMuc=" + danhMuc + ", nhaXuatBan=" + nhaXuatBan + ", tacGia=" + tacGia + ", tenSach="
                + tenSach + "]";
    }

}
