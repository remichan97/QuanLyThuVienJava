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
                sv.setId(rs.getString("id"));
                sv.setTen(rs.getString("ten"));
                sv.setSdt(rs.getString("so_dien_thoai"));
                sv.setGioiTinh(rs.getInt("gioi_tinh"));
                sv.setEmail(rs.getString("email"));
                sv.setAnh(rs.getString("anh"));

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
            stm = con.prepareStatement("insert into sinh_vien (id,ten,so_dien_thoai,gioi_tinh,email,anh) values (?,?,?,?,?,?)");
            stm.setString(1, sv.getId());
            stm.setString(2, sv.getTen());
            stm.setString(3, sv.getSdt());
            stm.setInt(4, sv.getGioiTinh());
            stm.setString(5, sv.getEmail());
            stm.setString(6, sv.getAnh());           

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
            stm = con.prepareStatement("update sinh_vien set ten = ?, so_dien_thoai = ?, gioi_tinh = ?, email = ?, anh = ? where id = ?");
            stm.setString(1, sv.getTen());
            stm.setString(2, sv.getSdt());
            stm.setInt(3, sv.getGioiTinh());
            stm.setString(4, sv.getEmail());
            stm.setString(5, sv.getAnh());
            stm.setString(6, sv.getId());

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean toggleStatus(String id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update sinh_vien set status = !status where id = ?");
            stm.setString(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public boolean delete(String id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("update sinh_vien set status = false where id = ?");
            stm.setString(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    public static int countStudent() {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("select count(*) dem from sinh_vien where status = 1");
            ResultSet rs = stm.executeQuery();
            rs.next();

            return rs.getInt("dem");
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return -1;
    }
}
