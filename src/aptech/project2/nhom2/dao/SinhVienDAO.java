package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.SinhVien;
import aptech.project2.nhom2.util.DbConnect;

public class SinhVienDAO {
    public List<SinhVien> findAll() {
        List<SinhVien> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("select * from sinh_vien where status = 1");
            rs = stm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setId(rs.getInt("id"));
                sv.setTen(rs.getString("ten"));

                list.add(sv);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public boolean addNew(SinhVien sv) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("insert into sinh_vien (ten) values (?)");
            stm.setString(1, sv.getTen());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean update(SinhVien sv) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update sinh_vien set ten = ? where id = ?");
            stm.setString(1, sv.getTen());
            stm.setInt(2, sv.getId());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean toggleStatus(int id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update sinh_vien set status = !status where id = ?");
            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean delete(int id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update sinh_vien set status = false where id = ?");
            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }
}
