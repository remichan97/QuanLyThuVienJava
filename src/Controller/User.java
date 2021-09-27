package Controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    static Connection con = null;

    public Boolean dangNhap(String username, String password)
    {
        int count = 0;

        MD5Gen md5 = new MD5Gen();
        try {
            con = new Database().getConnection();

            String sql = "select count(*) from nguoidunghethong where TenDangNhap = ? and MatKhau = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, md5.getMD5(password));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count= rs.getInt("count(*)");
            }

        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        } finally
        {
            try {
                if (con != null) {
                    con.close();
                }    
            } catch (Exception e) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }
}
