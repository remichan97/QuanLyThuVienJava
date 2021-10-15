package aptech.project2.nhom2.model;

public class DanhMucSach {
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

    public DanhMucSach(String ten) {
        this.ten = ten;
    }

    public DanhMucSach() {
    }

    public DanhMucSach(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    
}
