package aptech.project2.nhom2.model;

public class ThongTinSach {
    private int id;
    private String ten;
    private TacGia tacGia;
    private DanhMucSach danhMucSach;
    private NhaXuatBan nhaXuatBan;
    private int soLuong;
    private int soLuongDaMuon;
    private String moTa;
    private String anh;
    private boolean status;
    
//`id`, `ten`, `id_tac_gia`, `id_danh_muc`, `so_luong`, `so_luong_da_muon`, `id_nha_xuat_ban`, `mo_ta`, `anh`, `status`

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public DanhMucSach getDanhMucSach() {
        return danhMucSach;
    }

    public void setDanhMucSach(DanhMucSach danhMucSach) {
        this.danhMucSach = danhMucSach;
    }

    public NhaXuatBan getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuongDaMuon() {
        return soLuongDaMuon;
    }

    public void setSoLuongDaMuon(int soLuongDaMuon) {
        this.soLuongDaMuon = soLuongDaMuon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ThongTinSach() {
    }

    public ThongTinSach(String ten, TacGia tacGia, DanhMucSach danhMucSach, NhaXuatBan nhaXuatBan, int soLuong,
            String moTa, String anh) {
        this.ten = ten;
        this.tacGia = tacGia;
        this.danhMucSach = danhMucSach;
        this.nhaXuatBan = nhaXuatBan;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.anh = anh;
    }

    public ThongTinSach(int id, String ten, TacGia tacGia, DanhMucSach danhMucSach, NhaXuatBan nhaXuatBan, int soLuong,
            String moTa, String anh) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.danhMucSach = danhMucSach;
        this.nhaXuatBan = nhaXuatBan;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.anh = anh;
    }

    
}
