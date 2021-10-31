package aptech.project2.nhom2.model;

import java.util.Date;

public class MuonSach {
    private int id;
    private SinhVien sinhVien;
    private ThongTinSach tSach;
    private Date ngay_muon;
    private Date ngay_tra;
    private Date ngay_tra_thuc_te;
    private String ghi_chu;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public ThongTinSach gettSach() {
        return tSach;
    }

    public void settSach(ThongTinSach tSach) {
        this.tSach = tSach;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(Date ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public Date getNgay_tra_thuc_te() {
        return ngay_tra_thuc_te;
    }

    public void setNgay_tra_thuc_te(Date ngay_tra_thuc_te) {
        this.ngay_tra_thuc_te = ngay_tra_thuc_te;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MuonSach(SinhVien sinhVien, ThongTinSach tSach, String ghi_chu, int status) {
        this.sinhVien = sinhVien;
        this.tSach = tSach;
        this.ghi_chu = ghi_chu;
        this.status = status;
    }

    public MuonSach() {
    }
    
}
