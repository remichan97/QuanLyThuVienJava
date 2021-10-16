package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.NguoiDungHeThong;
import aptech.project2.nhom2.util.DbConnect;

public class NguoiDungHeThongDAO {
    public static List<NguoiDungHeThong> findAll() {
        List<NguoiDungHeThong> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("select * from nguoi_dung_he_thong where status = 1");
            rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDungHeThong ndht = new NguoiDungHeThong();
                ndht.setUsername(rs.getString("ten_dang_nhap"));
                ndht.setPassword(rs.getString("mat_khau"));

                list.add(ndht);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public static boolean addNew(NguoiDungHeThong ndht) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "insert into nguoi_dung_he_thong (ten_dang_nhap, mat_khau, role) values (?, ?, ?)");
            stm.setString(1, ndht.getUsername());
            stm.setString(2, ndht.getPassword());
            stm.setString(3, ndht.getUsername());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public static boolean update(NguoiDungHeThong ndht) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update nguoi_dung_he_thong set Mat_khau = ? where ten_dang_nhap = ?");
            stm.setString(1, ndht.getPassword());
            stm.setString(2, ndht.getUsername());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public static boolean toggleStatus(String username) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update nguoi_dung_he_thong set status = !status where id = ?");
            stm.setString(1, username);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public static boolean delete(String username) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update nguoi_dung_he_thong set status = false where id = ?");
            stm.setString(1, username);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public static boolean signIn(String username, String password) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "select count(*) dem from nguoi_dung_he_thong where ten_dang_nhap = ? and mat_khau = ?");
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();

            return rs.getInt("dem") > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }
}