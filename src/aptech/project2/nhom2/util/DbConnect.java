package aptech.project2.nhom2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnect {
    public static Connection open() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuvien", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void close(Connection con, PreparedStatement pre, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pre != null) {
            try {
                pre.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
