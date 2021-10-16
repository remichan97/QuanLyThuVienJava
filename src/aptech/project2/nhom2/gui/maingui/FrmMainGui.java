/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.gui.maingui;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import aptech.project2.nhom2.dao.DanhMucSachDAO;
import aptech.project2.nhom2.dao.NhaXuatBanDAO;
import aptech.project2.nhom2.dao.TacGiaDAO;
import aptech.project2.nhom2.dao.ThongTinSachDAO;
import aptech.project2.nhom2.gui.dialoguebox.DialogDanhMuc;
import aptech.project2.nhom2.gui.signin.FrmSignIn;
import aptech.project2.nhom2.model.ComboBoxData;
import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.model.TacGia;
import aptech.project2.nhom2.model.ThongTinSach;
import javafx.application.Application;

/**
 *
 * @author Mirai
 */
public class FrmMainGui extends javax.swing.JFrame {

    /**
     * Creates new form FrmMainGui
     */
    private TacGiaDAO tacGiaDAO = new TacGiaDAO();
    private NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
    private DanhMucSachDAO danhMucSachDAO = new DanhMucSachDAO();
    private ThongTinSachDAO thongTinSachDAO = new ThongTinSachDAO();
    
    private DefaultComboBoxModel tacGiaModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel danhMucSachModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel nhaXuatBanModel = new DefaultComboBoxModel<>();
    
    public FrmMainGui() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        loadBook();
        loadData4ComboBox();

        cmbTacGia.setSelectedIndex(-1);
        cmbNhaXuatBan.setSelectedIndex(-1);
        cmbDanhMuc.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabDanhMucSach = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbTacGia = new javax.swing.JComboBox<>();
        btnTacGia = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbDanhMuc = new javax.swing.JComboBox<>();
        btnDanhMucSach = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        numSoLuong = new javax.swing.JSpinner();
        btnAddBook = new javax.swing.JButton();
        btnEditBook = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        btnResetBook = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cmbNhaXuatBan = new javax.swing.JComboBox<>();
        btnNhaXuatBan = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFileAnh = new javax.swing.JTextField();
        btnChonAnh = new javax.swing.JButton();
        btnMuonSach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnTimKiemNangCao = new javax.swing.JButton();
        panelOverview = new javax.swing.JPanel();
        panelTongSoSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTongSoSach = new javax.swing.JLabel();
        panelTongSoSinhVien = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbSosinhVien = new javax.swing.JLabel();
        panelTongSoSachMuon = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbSoSachMuon = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDanhSachSinhVien = new javax.swing.JMenuItem();
        menuDanhSachNguoiDung = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuMuonSach = new javax.swing.JMenuItem();
        menuTraSach = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuDangXuat = new javax.swing.JMenuItem();
        menuThoat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sách"));

        jLabel7.setText("Tên sách");

        jLabel8.setText("Tác giả");

        btnTacGia.setText("Quản lý danh mục tác giả");
        btnTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacGiaActionPerformed(evt);
            }
        });

        jLabel9.setText("Danh mục");

        btnDanhMucSach.setText("Quản lý danh mục sách");
        btnDanhMucSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucSachActionPerformed(evt);
            }
        });

        jLabel10.setText("Số lượng");

        numSoLuong.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));

        btnAddBook.setText("Thêm sách");
        btnAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookActionPerformed(evt);
            }
        });

        btnEditBook.setText("Sửa thông tin");

        btnDeleteBook.setText("Xóa sách");

        btnResetBook.setText("Điền lại");

        jLabel12.setText("Nhà xuất bản");

        btnNhaXuatBan.setText("Quản lý danh mục nhà xuất bản");
        btnNhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaXuatBanActionPerformed(evt);
            }
        });

        jLabel13.setText("Mô tả");

        jLabel14.setText("Ảnh");

        txtFileAnh.setEnabled(false);

        btnChonAnh.setText("Chọn ảnh");

        btnMuonSach.setText("Mượn sách");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTenSach)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(cmbTacGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDanhMucSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(cmbNhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMoTa)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnResetBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMuonSach)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFileAnh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChonAnh)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(numSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cmbNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDanhMucSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFileAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonAnh))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBook)
                    .addComponent(btnEditBook)
                    .addComponent(btnDeleteBook)
                    .addComponent(btnResetBook)
                    .addComponent(btnMuonSach))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sách", "Tác giả", "Danh mục sách", "Nhà xuất bản", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setText("Tìm tên sách");

        btnTimKiem.setText("Tìm kiếm");

        btnTimKiemNangCao.setText("Tìm kiếm nâng cao");

        javax.swing.GroupLayout tabDanhMucSachLayout = new javax.swing.GroupLayout(tabDanhMucSach);
        tabDanhMucSach.setLayout(tabDanhMucSachLayout);
        tabDanhMucSachLayout.setHorizontalGroup(
            tabDanhMucSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(tabDanhMucSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKeyWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemNangCao)
                .addGap(8, 8, 8))
        );
        tabDanhMucSachLayout.setVerticalGroup(
            tabDanhMucSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDanhMucSachLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDanhMucSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnTimKiemNangCao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTongSoSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTongSoSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mirai\\Desktop\\QuanLyThuVienProject\\icons\\icons8_books_48px.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Số lượng sách");

        lbTongSoSach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTongSoSach.setText("0");

        javax.swing.GroupLayout panelTongSoSachLayout = new javax.swing.GroupLayout(panelTongSoSach);
        panelTongSoSach.setLayout(panelTongSoSachLayout);
        panelTongSoSachLayout.setHorizontalGroup(
            panelTongSoSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongSoSachLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(panelTongSoSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTongSoSachLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(panelTongSoSachLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lbTongSoSach)))
                .addGap(0, 60, Short.MAX_VALUE))
        );
        panelTongSoSachLayout.setVerticalGroup(
            panelTongSoSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTongSoSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTongSoSach)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTongSoSinhVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTongSoSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mirai\\Desktop\\QuanLyThuVienProject\\icons\\icons8_person_48px.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Tổng số sinh viên");

        lbSosinhVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSosinhVien.setText("0");

        javax.swing.GroupLayout panelTongSoSinhVienLayout = new javax.swing.GroupLayout(panelTongSoSinhVien);
        panelTongSoSinhVien.setLayout(panelTongSoSinhVienLayout);
        panelTongSoSinhVienLayout.setHorizontalGroup(
            panelTongSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongSoSinhVienLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(panelTongSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTongSoSinhVienLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5))
                    .addGroup(panelTongSoSinhVienLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lbSosinhVien)))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        panelTongSoSinhVienLayout.setVerticalGroup(
            panelTongSoSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTongSoSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSosinhVien)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTongSoSachMuon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTongSoSachMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mirai\\Desktop\\QuanLyThuVienProject\\icons\\icons8_borrow_book_48px.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Số lượng sách đang mượn");

        lbSoSachMuon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbSoSachMuon.setText("0");

        javax.swing.GroupLayout panelTongSoSachMuonLayout = new javax.swing.GroupLayout(panelTongSoSachMuon);
        panelTongSoSachMuon.setLayout(panelTongSoSachMuonLayout);
        panelTongSoSachMuonLayout.setHorizontalGroup(
            panelTongSoSachMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongSoSachMuonLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTongSoSachMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(panelTongSoSachMuonLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lbSoSachMuon)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        panelTongSoSachMuonLayout.setVerticalGroup(
            panelTongSoSachMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTongSoSachMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSoSachMuon)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelOverviewLayout = new javax.swing.GroupLayout(panelOverview);
        panelOverview.setLayout(panelOverviewLayout);
        panelOverviewLayout.setHorizontalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTongSoSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTongSoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTongSoSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOverviewLayout.setVerticalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelTongSoSinhVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTongSoSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTongSoSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(null);

        jMenu1.setText("Chức năng");

        menuDanhSachSinhVien.setText("Danh sách sinh viên");
        jMenu1.add(menuDanhSachSinhVien);

        menuDanhSachNguoiDung.setText("Danh sách người dùng");
        jMenu1.add(menuDanhSachNguoiDung);
        jMenu1.add(jSeparator1);

        menuMuonSach.setText("Mượn sách");
        jMenu1.add(menuMuonSach);

        menuTraSach.setText("Trả sách");
        jMenu1.add(menuTraSach);
        jMenu1.add(jSeparator2);

        menuDangXuat.setText("Đăng xuất");
        menuDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(menuDangXuat);

        menuThoat.setText("Thoát");
        menuThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThoatActionPerformed(evt);
            }
        });
        jMenu1.add(menuThoat);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabDanhMucSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabDanhMucSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
        // TODO add your handling code here:
        ComboBoxData data = (ComboBoxData) cmbTacGia.getSelectedItem();
        System.out.println(data.getValue()+","+data.getLabel());
    }//GEN-LAST:event_btnAddBookActionPerformed

    private void btnTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacGiaActionPerformed
        // TODO add your handling code here:
        DialogDanhMuc dialog = new DialogDanhMuc(null, true, 1);
        dialog.setVisible(true);
        loadData4ComboBox();
    }//GEN-LAST:event_btnTacGiaActionPerformed

    private void btnDanhMucSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucSachActionPerformed
        // TODO add your handling code here:
        DialogDanhMuc dialog = new DialogDanhMuc(null, true, 2);
        dialog.setVisible(true);
        loadData4ComboBox();
    }//GEN-LAST:event_btnDanhMucSachActionPerformed

    private void btnNhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaXuatBanActionPerformed
        // TODO add your handling code here:
        DialogDanhMuc dialog = new DialogDanhMuc(null, true, 3);
        dialog.setVisible(true);
        loadData4ComboBox();
    }//GEN-LAST:event_btnNhaXuatBanActionPerformed

    private void menuThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuThoatActionPerformed

    private void menuDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDangXuatActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất phần mềm", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            FrmSignIn frm = new FrmSignIn();
            this.setVisible(false);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_menuDangXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         new FrmMainGui().setVisible(true);
        //     }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnDanhMucSach;
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnEditBook;
    private javax.swing.JButton btnMuonSach;
    private javax.swing.JButton btnNhaXuatBan;
    private javax.swing.JButton btnResetBook;
    private javax.swing.JButton btnTacGia;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemNangCao;
    private javax.swing.JComboBox<String> cmbDanhMuc;
    private javax.swing.JComboBox<String> cmbNhaXuatBan;
    private javax.swing.JComboBox<String> cmbTacGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbSoSachMuon;
    private javax.swing.JLabel lbSosinhVien;
    private javax.swing.JLabel lbTongSoSach;
    private javax.swing.JMenuItem menuDangXuat;
    private javax.swing.JMenuItem menuDanhSachNguoiDung;
    private javax.swing.JMenuItem menuDanhSachSinhVien;
    private javax.swing.JMenuItem menuMuonSach;
    private javax.swing.JMenuItem menuThoat;
    private javax.swing.JMenuItem menuTraSach;
    private javax.swing.JSpinner numSoLuong;
    private javax.swing.JPanel panelOverview;
    private javax.swing.JPanel panelTongSoSach;
    private javax.swing.JPanel panelTongSoSachMuon;
    private javax.swing.JPanel panelTongSoSinhVien;
    private javax.swing.JPanel tabDanhMucSach;
    private javax.swing.JTextField txtFileAnh;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables

    private void loadBook() {
        List<ThongTinSach> sachs = thongTinSachDAO.findAll();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        sachs.forEach(it -> {
            model.addRow(new Object[] {
                it.getTen(),
                it.getTacGia().getTen(),
                it.getDanhMucSach().getTen(),
                it.getNhaXuatBan().getTen(),
                it.getSoLuong()
            });
        });
    }

    private void loadData4ComboBox() {
        List<TacGia> tacGias = tacGiaDAO.findAll();
        tacGias.forEach(it -> {
//            cmbTacGia.addItem(it.getTen());
            tacGiaModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
        });
        List<DanhMucSach> danhMucSach = danhMucSachDAO.findAll();
        danhMucSach.forEach(it -> {
            danhMucSachModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
        });
        List<NhaXuatBan> nhaXuatBans = nhaXuatBanDAO.findAll();
        nhaXuatBans.forEach(it -> {
            nhaXuatBanModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
        });

        cmbTacGia.setModel(tacGiaModel);
        cmbNhaXuatBan.setModel(nhaXuatBanModel);
        cmbDanhMuc.setModel(danhMucSachModel);
    }

}
