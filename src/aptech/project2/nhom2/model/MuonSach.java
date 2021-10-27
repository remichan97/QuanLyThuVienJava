package aptech.project2.nhom2.model;

import java.util.Date;

public class MuonSach {
    private int id_muon_sach;
    private SinhVien sinhVien;
    private ThongTinSach tSach;
    private Date ngay_muon;
    private Date ngay_tra;
    private Date ngay_tra_thuc_te;
    private int so_luong_muon;

    public int getId_muon_sach() {
        return id_muon_sach;
    }

    public void setId_muon_sach(int id_muon_sach) {
        this.id_muon_sach = id_muon_sach;
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

    public int getSo_luong_muon() {
        return so_luong_muon;
    }

    public void setSo_luong_muon(int so_luong_muon) {
        this.so_luong_muon = so_luong_muon;
    }

    public MuonSach() {
    }

    public MuonSach(SinhVien sinhVien, ThongTinSach tSach, Date ngay_muon, Date ngay_tra, int so_luong_muon) {
        this.sinhVien = sinhVien;
        this.tSach = tSach;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.so_luong_muon = so_luong_muon;
    }

}
