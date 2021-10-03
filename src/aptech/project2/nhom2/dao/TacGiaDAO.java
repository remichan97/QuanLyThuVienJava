package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.TacGia;
import aptech.project2.nhom2.util.DbConnect;

public class TacGiaDAO {
    public List<TacGia> findAll() {
        List<TacGia> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("select * from tac_gia where status = 1");
            rs = stm.executeQuery();
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setId(rs.getInt("id"));
                tg.setTen(rs.getString("ten"));

                list.add(tg);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public boolean addNew(TacGia tg) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("insert into tac_gia (ten) values (?)");
            stm.setString(1, tg.getTen());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean update(TacGia tg) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update tac_gia set ten = ? where id = ?");
            stm.setString(1, tg.getTen());
            stm.setInt(2, tg.getId());

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
            stm = con.prepareStatement("update tac_gia set status = !status where id = ?");
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
            stm = con.prepareStatement("update tac_gia set status = false where id = ?");
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
