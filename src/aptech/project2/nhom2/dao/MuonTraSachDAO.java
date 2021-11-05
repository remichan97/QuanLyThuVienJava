package aptech.project2.nhom2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.MuonSach;
import aptech.project2.nhom2.model.SinhVien;
import aptech.project2.nhom2.model.ThongTinSach;
import aptech.project2.nhom2.util.DbConnect;

public class MuonTraSachDAO {
    public static List<MuonSach> getAllBorrowList() {
        List<MuonSach> muonSachs = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(
                    "SELECT a.id, a.id_sinh_vien, c.ten ten_sinh_vien, a.id_sach, b.ten ten_sach_muon, a.ngay_muon, a.ngay_tra, a.ngay_tra_thuc_te, a.ghi_chu, a.status, a.le_phi_phat \n"
                            + "FROM muon_sach a \n" + "inner join thong_tin_sach b on a.id_sach = b.id \n"
                            + "inner join sinh_vien c on a.id_sinh_vien = c.id");
            rs = stm.executeQuery();
            while (rs.next()) {
                MuonSach muonSach = new MuonSach();
                muonSach.setId(rs.getInt("id"));
                muonSach.setNgay_muon(rs.getDate("ngay_muon"));
                muonSach.setNgay_tra(rs.getDate("ngay_tra"));
                muonSach.setNgay_tra_thuc_te(rs.getDate("ngay_tra_thuc_te"));
                muonSach.setGhi_chu(rs.getString("ghi_chu"));
                muonSach.setStatus(rs.getInt("status"));
                muonSach.setLe_phi_phat(rs.getInt("le_phi_phat"));

                SinhVien sv = new SinhVien();
                sv.setId(rs.getString("id_sinh_vien"));
                sv.setTen(rs.getString("ten_sinh_vien"));

                ThongTinSach sach = new ThongTinSach(rs.getInt("id_sach"), rs.getString("ten_sach_muon"));

                muonSach.setSinhVien(sv);
                muonSach.settSach(sach);

                muonSachs.add(muonSach);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return muonSachs;
    }

    public static boolean borrowBooks(MuonSach muonSach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(
                    "insert into muon_sach (id_sinh_vien, id_sach, ngay_muon, ngay_tra, ghi_chu, status) values (?, ?, ?, ?, ?, ?)");
            stm.setString(1, muonSach.getSinhVien().getId());
            stm.setInt(2, muonSach.gettSach().getId());
            stm.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7)));
            stm.setString(5, muonSach.getGhi_chu());
            stm.setInt(6, muonSach.getStatus());

            if (stm.executeUpdate() > 0) {
                issueBooks(muonSach.gettSach().getId());
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return false;

    }

    public static List<MuonSach> locMuonSach(String maSinhVien) {
        String sql1 = "select a.id_sach, b.ten ten_sach_muon, a.ngay_muon from muon_sach a inner join thong_tin_sach b on a.id_sach = b.id where id_sinh_vien = ? and a.status = 0";
        List<MuonSach> dataMs = new ArrayList<>();
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(sql1);
            stm.setString(1, maSinhVien);
            rs = stm.executeQuery();

            while (rs.next()) {
                MuonSach test = new MuonSach();
                test.settSach(new ThongTinSach(rs.getInt("id_sach_muon"), rs.getString("ten_sach_muon")));
                test.setNgay_muon(rs.getDate("ngay_muon"));

                dataMs.add(test);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return dataMs;
    }

    public static void returnBook(MuonSach traSach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            String sql1 = "update muon_sach set ngay_tra_thuc_te = ?, status = ? where id = ?";

            stm = con.prepareStatement(sql1);
            stm.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setInt(2, traSach.getStatus());
            stm.setInt(3, traSach.getId());

            stm.executeUpdate();

            updateBook(traSach.gettSach().getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static void issueBooks(int id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con
                    .prepareStatement("update thong_tin_sach set so_luong_da_muon = so_luong_da_muon + 1 where id = ?");
            stm.setInt(1, id);

            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static void lateReturn(MuonSach traMuon) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            String sql1 = "update muon_sach set ngay_tra_thuc_te = ?, status = ?, le_phi_phat = ?, ghi_chu = ? where id = ?";

            stm = con.prepareStatement(sql1);
            stm.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setInt(2, traMuon.getStatus());
            stm.setInt(3, traMuon.getLe_phi_phat());
            stm.setString(4, traMuon.getGhi_chu());
            stm.setInt(5, traMuon.getId());

            stm.executeUpdate();

            updateBook(traMuon.gettSach().getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static void updateBook(int idSach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con
                    .prepareStatement("update thong_tin_sach set so_luong_da_muon = so_luong_da_muon - 1 where id = ?");
            stm.setInt(1, idSach);

            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static void matSach(int idSach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("update thong_tin_sach set so_luong = so_luong - 1 where id = ?");
            stm.setInt(1, idSach);

            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static void lostBook(MuonSach matSach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            String sql1 = "update muon_sach set ngay_tra_thuc_te = ?, status = ?, ghi_chu = ? where id = ?";

            stm = con.prepareStatement(sql1);
            stm.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stm.setInt(2, matSach.getStatus());
            stm.setString(3, matSach.getGhi_chu());
            stm.setInt(4, matSach.getId());

            stm.executeUpdate();

            updateBook(matSach.gettSach().getId());
            matSach(matSach.gettSach().getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbConnect.close(con, stm, rs);
        }
    }

    public static int countIssued() {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement("select count(distinct id_sach) dem from muon_sach where status = 0");
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
