package aptech.project2.nhom2.model;

public class SinhVien {
    public SinhVien() {
    }

    public SinhVien(String ten, String sdt, ComboBoxData gioiTinh, String email, String anh) {
        this.ten = ten;
        Sdt = sdt;
        GioiTinh = gioiTinh;
        Email = email;
        Anh = anh;
    }

    public SinhVien(String id, String ten, String sdt, ComboBoxData gioiTinh, String email, String anh) {
        this.id = id;
        this.ten = ten;
        Sdt = sdt;
        GioiTinh = gioiTinh;
        Email = email;
        Anh = anh;
    }

    private String id;
    private String ten;
    private String Sdt;
    private ComboBoxData GioiTinh;
    private String Email;
    private String Anh;

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public ComboBoxData getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(ComboBoxData gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
}
