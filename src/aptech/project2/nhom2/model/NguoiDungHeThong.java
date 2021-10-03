package aptech.project2.nhom2.model;

public class NguoiDungHeThong {
    private String username;
    private String password;
    private enum role {Admin, NguoiDung}

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
    };

}
