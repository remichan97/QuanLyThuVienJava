package aptech.project2.nhom2.model;

public class NguoiDungHeThong {
    private String full_name;
    private String username;
    private String password;
    private int admin;
    private int status;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public NguoiDungHeThong() {
    }

    public NguoiDungHeThong(String full_name, String username, String password) {
        this.full_name = full_name;
        this.username = username;
        this.password = password;
    }

    public NguoiDungHeThong(String username, String password) {
        this.username = username;
        this.password = password;
    };


}
