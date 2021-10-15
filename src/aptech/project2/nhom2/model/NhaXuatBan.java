package aptech.project2.nhom2.model;

public class NhaXuatBan {
    private int id;
    private String ten;

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

    public NhaXuatBan(String ten) {
        this.ten = ten;
    }

    public NhaXuatBan() {
    }

    public NhaXuatBan(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
}
