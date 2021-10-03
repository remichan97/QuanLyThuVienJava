package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.util.DbConnect;

public class DanhMucSachDAO {
    public List<DanhMucSach> findAll() {
        List<DanhMucSach> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("select * from danh_muc_sach where status = 1");
            rs = stm.executeQuery();
            while (rs.next()) {
                DanhMucSach dmsach = new DanhMucSach();
                dmsach.setId(rs.getInt("id"));
                dmsach.setTen(rs.getString("ten"));

                list.add(dmsach);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public boolean addNew(DanhMucSach dmsach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("insert into danh_muc_sach (ten) values (?)");
            stm.setString(1, dmsach.getTen());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean update(DanhMucSach dmsach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update danh_muc_sach set ten = ? where id = ?");
            stm.setString(1, dmsach.getTen());
            stm.setInt(2, dmsach.getId());

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
            stm = con.prepareStatement("update danh_muc_sach set status = !status where id = ?");
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
            stm = con.prepareStatement("update danh_muc_sach set status = false where id = ?");
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
