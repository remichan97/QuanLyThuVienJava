package aptech.project2.nhom2.dao;

import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.model.TacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aptech.project2.nhom2.model.ThongTinSach;
import aptech.project2.nhom2.util.DbConnect;

public class ThongTinSachDAO {

    // public List<ThongTinSach> findAll() {
    // List<ThongTinSach> list = new ArrayList<>();
    //
    // Connection con = DbConnect.open();
    // PreparedStatement stm = null;
    // ResultSet rs = null;
    //
    // try {
    // stm = con.prepareStatement("select s.id, s.ten, s.so_luong,
    // s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
    // + " tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten
    // ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach
    // s "
    // + " inner join tac_gia tg on s.id_tac_gia = tg.id"
    // + " INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
    // + " inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status =
    // 1");
    // rs = stm.executeQuery();
    // while (rs.next()) {
    // ThongTinSach sach = new ThongTinSach();
    // sach.setId(rs.getInt("id"));
    // sach.setTen(rs.getString("ten"));
    // sach.setSoLuong(rs.getInt("so_luong"));
    // sach.setSoLuongDaMuon(rs.getInt("so_luong_da_muon"));
    // sach.setMoTa(rs.getString("mo_ta"));
    // sach.setAnh(rs.getString("anh"));
    // sach.setStatus(rs.getBoolean("status"));
    //
    // DanhMucSach danhMuc = new DanhMucSach();
    // danhMuc.setId(rs.getInt("id_danh_muc"));
    // danhMuc.setTen(rs.getString("ten_danh_muc"));
    //
    // NhaXuatBan nxb = new NhaXuatBan();
    // nxb.setId(rs.getInt("id_nha_xuat_ban"));
    // nxb.setTen(rs.getString("ten_nha_xuat_ban"));
    //
    // TacGia tg = new TacGia();
    // tg.setId(rs.getInt("id_tac_gia"));
    // tg.setTen(rs.getString("ten_tac_gia"));
    //
    // sach.setTacGia(tg);
    // sach.setDanhMucSach(danhMuc);
    // sach.setNhaXuatBan(nxb);
    //
    // list.add(sach);
    // }
    // } catch (SQLException ex) {
    // System.out.println("Loi: " + ex.getMessage());
    // } finally {
    // DbConnect.close(con, stm, rs);
    // }
    //
    // return list;
    // }
    public List<ThongTinSach> findAll() {
        return this.findBySql(null, "select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
                + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
                + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
                + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
                + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1");
    }

    public List<ThongTinSach> findByNXB(int nxbID) {
        return this.findBySql(nxbID, "select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
                + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
                + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
                + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
                + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1 and s.id_nha_xuat_ban = ?");
    }

    // public List<ThongTinSach> findByTen(String ten) { //thay thế bởi Stream trên GUI
    //     List<ThongTinSach> list = new ArrayList<>();

    //     Connection con = DbConnect.open();
    //     PreparedStatement stm = null;
    //     ResultSet rs = null;

    //     try {
    //         stm = con.prepareStatement("select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
    //                 + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
    //                 + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
    //                 + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
    //                 + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1 and s.ten like ?");
    //         stm.setString(1, "%" + ten + "%");
    //         rs = stm.executeQuery();
    //         while (rs.next()) {
    //             ThongTinSach sach = new ThongTinSach();
    //             sach.setId(rs.getInt("id"));
    //             sach.setTen(rs.getString("ten"));
    //             sach.setSoLuong(rs.getInt("so_luong"));
    //             sach.setSoLuongDaMuon(rs.getInt("so_luong_da_muon"));
    //             sach.setMoTa(rs.getString("mo_ta"));
    //             sach.setAnh(rs.getString("anh"));
    //             sach.setStatus(rs.getBoolean("status"));

    //             DanhMucSach danhMuc = new DanhMucSach();
    //             danhMuc.setId(rs.getInt("id_danh_muc"));
    //             danhMuc.setTen(rs.getString("ten_danh_muc"));

    //             NhaXuatBan nxb = new NhaXuatBan();
    //             nxb.setId(rs.getInt("id_nha_xuat_ban"));
    //             nxb.setTen(rs.getString("ten_nha_xuat_ban"));

    //             TacGia tg = new TacGia();
    //             tg.setId(rs.getInt("id_tac_gia"));
    //             tg.setTen(rs.getString("ten_tac_gia"));

    //             sach.setTacGia(tg);
    //             sach.setDanhMucSach(danhMuc);
    //             sach.setNhaXuatBan(nxb);

    //             list.add(sach);
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Loi: " + ex.getMessage());
    //     } finally {
    //         DbConnect.close(con, stm, rs);
    //     }

    //     return list;
    // }

    public List<ThongTinSach> findByTacGia(int tacGiaID) {
        return this.findBySql(tacGiaID, "select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
                + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
                + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
                + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
                + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1 and s.id_tac_gia = ?");
    }

    public List<ThongTinSach> findByDanhMuc(int danhMucID) {
        return this.findBySql(danhMucID, "select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
                + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
                + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
                + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
                + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1 and s.id_danh_muc = ?");

        // List<ThongTinSach> list = new ArrayList<>();
        //
        // Connection con = DbConnect.open();
        // PreparedStatement stm = null;
        // ResultSet rs = null;
        //
        // try {
        // stm = con.prepareStatement("select s.id, s.ten, s.so_luong,
        // s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
        // + " tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten
        // ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach
        // s "
        // + " inner join tac_gia tg on s.id_tac_gia = tg.id"
        // + " INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
        // + " inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1
        // and s.id_danh_muc = ?");
        // stm.setInt(1, danhMucID);
        //
        // rs = stm.executeQuery();
        // while (rs.next()) {
        // ThongTinSach sach = new ThongTinSach();
        // sach.setId(rs.getInt("id"));
        // sach.setTen(rs.getString("ten"));
        // sach.setSoLuong(rs.getInt("so_luong"));
        // sach.setSoLuongDaMuon(rs.getInt("so_luong_da_muon"));
        // sach.setMoTa(rs.getString("mo_ta"));
        // sach.setAnh(rs.getString("anh"));
        // sach.setStatus(rs.getBoolean("status"));
        //
        // DanhMucSach danhMuc = new DanhMucSach();
        // danhMuc.setId(rs.getInt("id_danh_muc"));
        // danhMuc.setTen(rs.getString("ten_danh_muc"));
        //
        // NhaXuatBan nxb = new NhaXuatBan();
        // nxb.setId(rs.getInt("id_nha_xuat_ban"));
        // nxb.setTen(rs.getString("ten_nha_xuat_ban"));
        //
        // TacGia tg = new TacGia();
        // tg.setId(rs.getInt("id_tac_gia"));
        // tg.setTen(rs.getString("ten_tac_gia"));
        //
        // sach.setTacGia(tg);
        // sach.setDanhMucSach(danhMuc);
        // sach.setNhaXuatBan(nxb);
        //
        // list.add(sach);
        // }
        // } catch (SQLException ex) {
        // System.out.println("Loi: " + ex.getMessage());
        // } finally {
        // DbConnect.close(con, stm, rs);
        // }
        //
        // return list;
    }

    public List<ThongTinSach> findBySql(Integer value, String sql) {
        List<ThongTinSach> list = new ArrayList<>();

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(sql);
            if (value != null) {
                stm.setInt(1, value);
            }

            rs = stm.executeQuery();
            while (rs.next()) {
                ThongTinSach sach = new ThongTinSach();
                sach.setId(rs.getInt("id"));
                sach.setTen(rs.getString("ten"));
                sach.setSoLuong(rs.getInt("so_luong"));
                sach.setSoLuongDaMuon(rs.getInt("so_luong_da_muon"));
                sach.setMoTa(rs.getString("mo_ta"));
                sach.setAnh(rs.getString("anh"));
                sach.setStatus(rs.getBoolean("status"));

                DanhMucSach danhMuc = new DanhMucSach();
                danhMuc.setId(rs.getInt("id_danh_muc"));
                danhMuc.setTen(rs.getString("ten_danh_muc"));

                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getInt("id_nha_xuat_ban"));
                nxb.setTen(rs.getString("ten_nha_xuat_ban"));

                TacGia tg = new TacGia();
                tg.setId(rs.getInt("id_tac_gia"));
                tg.setTen(rs.getString("ten_tac_gia"));

                sach.setTacGia(tg);
                sach.setDanhMucSach(danhMuc);
                sach.setNhaXuatBan(nxb);

                list.add(sach);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public List<ThongTinSach> searchAdvanced(String tenSach, Integer tacGiaID, Integer danhMucID, Integer nxbID) {
        List<ThongTinSach> list = new ArrayList<>();

        String sql = "select s.id, s.ten, s.so_luong, s.so_luong_da_muon, s.mo_ta, s.anh, s.status,"
                + "                  tg.id id_tac_gia, tg.ten ten_tac_gia, nxb.id id_nha_xuat_ban, nxb.ten ten_nha_xuat_ban, ds.id id_danh_muc, ds.ten ten_danh_muc from thong_tin_sach s "
                + "                 inner join tac_gia tg on s.id_tac_gia = tg.id"
                + "                 INNER join nha_xuat_ban nxb on s.id_nha_xuat_ban = nxb.id"
                + "                 inner join danh_muc_sach ds on s.id_danh_muc = ds.id where s.status = 1";
        sql = this.makewhere(sql, tenSach, tacGiaID, danhMucID, nxbID);

        Connection con = DbConnect.open();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(sql);
            this.setParams(stm, tenSach, tacGiaID, danhMucID, nxbID);
            rs = stm.executeQuery();
            while (rs.next()) {
                ThongTinSach sach = new ThongTinSach();
                sach.setId(rs.getInt("id"));
                sach.setTen(rs.getString("ten"));
                sach.setSoLuong(rs.getInt("so_luong"));
                sach.setSoLuongDaMuon(rs.getInt("so_luong_da_muon"));
                sach.setMoTa(rs.getString("mo_ta"));
                sach.setAnh(rs.getString("anh"));
                sach.setStatus(rs.getBoolean("status"));

                DanhMucSach danhMuc = new DanhMucSach();
                danhMuc.setId(rs.getInt("id_danh_muc"));
                danhMuc.setTen(rs.getString("ten_danh_muc"));

                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getInt("id_nha_xuat_ban"));
                nxb.setTen(rs.getString("ten_nha_xuat_ban"));

                TacGia tg = new TacGia();
                tg.setId(rs.getInt("id_tac_gia"));
                tg.setTen(rs.getString("ten_tac_gia"));

                sach.setTacGia(tg);
                sach.setDanhMucSach(danhMuc);
                sach.setNhaXuatBan(nxb);

                list.add(sach);
            }
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, rs);
        }

        return list;
    }

    public boolean addNew(ThongTinSach sach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        if (checkDelete(sach)) {
            int id = getDeletedID(sach);
            toggleStatus(id);
            updateMoTa(sach.getMoTa(), id);
            return true;
        } else {
            try {
                stm = con.prepareStatement(
                        "insert into thong_tin_sach (`ten`, `id_tac_gia`, `id_danh_muc`, `so_luong`, `id_nha_xuat_ban`, `mo_ta`, `anh`) VALUES (?, ?, ?, ?, ?, ?, ?)");
                stm.setString(1, sach.getTen());
                stm.setInt(2, sach.getTacGia().getId());
                stm.setInt(3, sach.getDanhMucSach().getId());
                stm.setInt(4, sach.getSoLuong());
                stm.setInt(5, sach.getNhaXuatBan().getId());
                stm.setString(6, sach.getMoTa());
                stm.setString(7, sach.getAnh());

                return stm.executeUpdate() > 0;
            } catch (SQLException ex) {
                System.out.println("Loi: " + ex.getMessage());
            } finally {
                DbConnect.close(con, stm, null);
            }
        }

        return false;
    }

    public boolean update(ThongTinSach sach) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "update thong_tin_sach set ten = ?, id_tac_gia = ?, id_danh_muc = ?, so_luong = ?, id_nha_xuat_ban = ?, mo_ta = ?, anh = ? where id = ?");
            stm.setString(1, sach.getTen());
            stm.setInt(2, sach.getTacGia().getId());
            stm.setInt(3, sach.getDanhMucSach().getId());
            stm.setInt(4, sach.getSoLuong());
            stm.setInt(5, sach.getNhaXuatBan().getId());
            stm.setString(6, sach.getMoTa());
            stm.setString(7, sach.getAnh());
            stm.setInt(8, sach.getId());

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
            stm = con.prepareStatement("update thong_tin_sach set status = !status where id = ?");
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
            stm = con.prepareStatement("update thong_tin_sach set status = false where id = ?");
            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    private String makewhere(String sql, String tenSach, Integer tacGiaID, Integer danhMucID, Integer nxbID) {
        if (danhMucID != null) {
            sql += " and ds.id = ?";
        }
        if (tenSach != null && !tenSach.isEmpty()) {
            sql += " and s.ten like ?";
        }
        if (nxbID != null) {
            sql += " and nxb.id = ?";
        }
        if (tacGiaID != null) {
            sql += " and tg.id = ?";
        }
        return sql;

    }

    private void setParams(PreparedStatement stm, String tenSach, Integer tacGiaID, Integer danhMucID, Integer nxbID)
            throws SQLException {
        int index = 1;

        if (danhMucID != null) {
            stm.setInt(index++, danhMucID);
        }
        if (tenSach != null && !tenSach.isEmpty()) {
            stm.setString(index++, "%" + tenSach + "%");
        }
        if (tacGiaID != null) {
            stm.setInt(index++, tacGiaID);
        }
        if (nxbID != null) {
            stm.setInt(index++, nxbID);
        }
    }

    private boolean checkDelete(ThongTinSach data) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "select count(*) dem from thong_tin_sach where ten = ? and id_tac_gia = ? and id_danh_muc = ? and id_nha_xuat_ban = ? and status = 0");
            stm.setString(1, data.getTen());
            stm.setInt(2, data.getTacGia().getId());
            stm.setInt(3, data.getDanhMucSach().getId());
            stm.setInt(4, data.getNhaXuatBan().getId());

            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("dem") > 0;
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return false;
    }

    private int getDeletedID(ThongTinSach data) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "select id from thong_tin_sach where ten = ? and id_tac_gia = ? and id_danh_muc = ? and id_nha_xuat_ban = ? and status = 0");
            stm.setString(1, data.getTen());
            stm.setInt(2, data.getTacGia().getId());
            stm.setInt(3, data.getDanhMucSach().getId());
            stm.setInt(4, data.getNhaXuatBan().getId());

            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
        return 0;
    }

    private void updateMoTa(String moTa, int id) {
        Connection con = DbConnect.open();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                    "update thong_tin_sach set mo_ta = ? where id = ?");
            stm.setString(1, moTa);
            stm.setInt(2, id);

            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            DbConnect.close(con, stm, null);
        }
    }
}
