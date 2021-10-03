package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.util.DbConnect;

public class NhaXuatBanDAO {
    public List<NhaXuatBan> findAll() {
        List<NhaXuatBan> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("select * from nha_xuat_ban where status = 1");
            rs = stm.executeQuery();
            while (rs.next()) {
                NhaXuatBan nsb = new NhaXuatBan();
                nsb.setId(rs.getInt("id"));
                nsb.setTen(rs.getString("ten"));

                list.add(nsb);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public boolean addNew(NhaXuatBan nsb) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("insert into nha_xuat_ban (ten) values (?)");
            stm.setString(1, nsb.getTen());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean update(NhaXuatBan nsb) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update nha_xuat_ban set ten = ? where id = ?");
            stm.setString(1, nsb.getTen());
            stm.setInt(2, nsb.getId());

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
            stm = con.prepareStatement("update nha_xuat_ban set status = !status where id = ?");
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
            stm = con.prepareStatement("update nha_xuat_ban set status = false where id = ?");
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
