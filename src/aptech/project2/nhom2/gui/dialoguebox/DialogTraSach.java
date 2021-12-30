/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.gui.dialoguebox;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import aptech.project2.nhom2.dao.MuonTraSachDAO;
import aptech.project2.nhom2.model.MuonSach;
import aptech.project2.nhom2.model.ThongTinSach;
import aptech.project2.nhom2.util.DateUtil;

/**
 *
 * @author Mirai
 */
public class DialogTraSach extends javax.swing.JDialog {

    /**
     * Creates new form DialogTraSach
     */

    private DefaultTableModel listIssuedModel = new DefaultTableModel(new Object[][] {},
            new String[] { "Mã sinh viên", "Mã sách mượn", "Ngày mượn", "Ngày hẹn trả", "Ghi chú" });
    private DefaultTableModel listReturnedModel = new DefaultTableModel(new Object[][] {},
            new String[] { "Mã sinh viên", "Mã sách mượn", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Ghi chú" });
    private DefaultTableModel listReturnedLateModel = new DefaultTableModel(new Object[][] {}, new String[] {
            "Mã sinh viên", "Mã sách mượn", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Lệ phí", "Ghi chú" });
    private DefaultTableModel listLostModel = new DefaultTableModel(new Object[][] {},
            new String[] { "Mã sinh viên", "Mã sách mượn", "Ngày mượn", "Ngày hẹn trả", "Ngày mất", "Ghi chú" });
    private DefaultTableModel listBannedModel = new DefaultTableModel(new Object[][] {},
            new String[] { "Mã sinh viên", "Ghi chú" });

    private List<MuonSach> dataList;
    private List<MuonSach> issued;
    private List<MuonSach> returned;
    private List<MuonSach> returnedLate;
    private List<MuonSach> lost;
    private List<MuonSach> banned;

    private final int lateFineThreshold = 300000;

    public DialogTraSach(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        loadData();

        this.setLocationRelativeTo(null);


        this.pack();
    }

    private void loadData() {
        dataList = MuonTraSachDAO.getAllBorrowList();

        issued = dataList.stream().filter(it -> it.getStatus() == 0).collect(Collectors.toList());

        listIssuedModel.setRowCount(0);
        issued.forEach(it -> {
            listIssuedModel.addRow(new Object[] { it.getSinhVien().getId(), it.gettSach().getId(),
                    DateUtil.convertDate(it.getNgay_muon()), DateUtil.convertDate(it.getNgay_tra()),
                    it.getGhi_chu(), });
        });

        returned = dataList.stream()
                .filter(it -> it.getStatus() == 1 && it.getNgay_tra_thuc_te().before(it.getNgay_tra()))
                .collect(Collectors.toList());

        listReturnedModel.setRowCount(0);
        returned.forEach(it -> {
            listReturnedModel.addRow(new Object[] { it.getSinhVien().getId(), it.gettSach().getId(),
                    DateUtil.convertDate(it.getNgay_muon()), DateUtil.convertDate(it.getNgay_tra()),
                    DateUtil.convertDate(it.getNgay_tra_thuc_te()), it.getGhi_chu(), });
        });

        returnedLate = dataList.stream()
                .filter(it -> it.getStatus() == 1 && it.getNgay_tra_thuc_te().after(it.getNgay_tra()))
                .collect(Collectors.toList());

        listReturnedLateModel.setRowCount(0);
        returnedLate.forEach(it -> {
            listReturnedLateModel.addRow(new Object[] { it.getSinhVien().getId(), it.gettSach().getId(),
                    DateUtil.convertDate(it.getNgay_muon()), DateUtil.convertDate(it.getNgay_tra()),
                    DateUtil.convertDate(it.getNgay_tra_thuc_te()), it.getLe_phi_phat(), it.getGhi_chu() });
        });

        lost = dataList.stream().filter(it -> it.getStatus() == 2).collect(Collectors.toList());

        listLostModel.setRowCount(0);
        lost.forEach(it -> {
            listLostModel.addRow(new Object[] { it.getSinhVien().getId(), it.gettSach().getId(),
                    DateUtil.convertDate(it.getNgay_muon()), DateUtil.convertDate(it.getNgay_tra()),
                    DateUtil.convertDate(it.getNgay_tra_thuc_te()), it.getGhi_chu(), });
        });

        banned = dataList.stream().filter(it -> it.getStatus() == 3).collect(Collectors.toList());

        listBannedModel.setRowCount(0);
        banned.forEach(it -> {
            listBannedModel.addRow(new Object[] {it.getSinhVien().getId(), it.getGhi_chu()});
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSinhVien = new javax.swing.JTextField();
        txtTenSachMuon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgayHenTra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnTraSach = new javax.swing.JButton();
        btnBaoMat = new javax.swing.JButton();
        btnChonLai = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Trả sách");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin trả sách"));

        jLabel1.setText("Tên người mượn");

        jLabel2.setText("Tên sách mượn");

        txtTenSinhVien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTenSinhVien.setEnabled(false);

        txtTenSachMuon.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTenSachMuon.setEnabled(false);

        jLabel3.setText("Ngày mượn");

        txtNgayMuon.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNgayMuon.setEnabled(false);

        jLabel4.setText("Ngày hẹn trả");

        txtNgayHenTra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNgayHenTra.setEnabled(false);

        jLabel5.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnTraSach.setText("Trả sách");
        btnTraSach.setEnabled(false);
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        btnBaoMat.setText("Báo mất");
        btnBaoMat.setEnabled(false);
        btnBaoMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoMatActionPerformed(evt);
            }
        });

        btnChonLai.setText("Chọn lại");
        btnChonLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonLaiActionPerformed(evt);
            }
        });

        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSinhVien))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSachMuon)
                            .addComponent(txtNgayMuon)
                            .addComponent(txtNgayHenTra, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaoMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChonLai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSachMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonLai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng dữ liệu"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel6.setText("Chọn dữ liệu cần xem");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang mượn", "Sách trả đúng hạn", "Trả muộn", "Báo mất", "Thu hồi quyền mượn sách" }));
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, 414, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCloseActionPerformed

    private void btnChonLaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChonLaiActionPerformed
        // TODO add your handling code here:
        jTable1.clearSelection();
        txtGhiChu.setText("");
        txtNgayMuon.setText("");
        txtNgayHenTra.setText("");
        txtTenSachMuon.setText("");
        txtTenSinhVien.setText("");

        buttonStatus(false);
    }// GEN-LAST:event_btnChonLaiActionPerformed

    private void btnBaoMatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBaoMatActionPerformed
        int index = jTable1.getSelectedRow();
        int id = issued.get(index).getId();

        ThongTinSach data = new ThongTinSach(issued.get(index).gettSach().getId(), null);

        String note = "\nSinh viên " + txtTenSinhVien.getText() + " làm mất quyển sách " + txtTenSachMuon.getText()
                + ", ngày " + DateUtil.convertDate(Date.from(Instant.now())) + ", mức đóng phạt 400.000 đống";

        MuonSach matSach = new MuonSach(id, data, txtGhiChu.getText() + note, 2);

        MuonTraSachDAO.lostBook(matSach);
        JOptionPane.showMessageDialog(null, "Đã báo mất sách", "Báo mất", JOptionPane.INFORMATION_MESSAGE);
        loadData();

    }// GEN-LAST:event_btnBaoMatActionPerformed

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraSachActionPerformed
        MuonSach traSach;
        
        int index = jTable1.getSelectedRow();

        int id = issued.get(index).getId();

        ThongTinSach data = new ThongTinSach(issued.get(index).gettSach().getId(), null);

        if (java.util.Calendar.getInstance().getTime().before(issued.get(index).getNgay_tra())) {
            traSach = new MuonSach(id, data, txtGhiChu.getText(), 1);
            MuonTraSachDAO.returnBook(traSach);
        } else {
            int diff = DateUtil.compareDate(new java.util.Date(issued.get(index).getNgay_tra().getTime()), java.util.Calendar.getInstance().getTime());
            if (diff <= 30) {
                int fine = diff * 10000;
                String note = "Sinh viên " + txtTenSinhVien.getText() + " trả muộn quyển " + txtTenSachMuon.getText() + " " + diff + " ngày, phạt " + fine + " đồng";
                traSach = new MuonSach(id, data, note, fine, 1);
                JOptionPane.showMessageDialog(null, note, "Trả sách muộn", JOptionPane.INFORMATION_MESSAGE);
                MuonTraSachDAO.lateReturn(traSach);
            } else {
                String note = "Sinh viên " + txtTenSinhVien.getText() + " trả muộn quyển " + txtTenSachMuon.getText() + " quá 30 ngày, phạt" + lateFineThreshold + " đồng, và bị thu hồi quyền mượn sách tại thư viện";
                traSach = new MuonSach(id, data, note, lateFineThreshold, 3);
                JOptionPane.showMessageDialog(null, note, "Trả sách muộn", JOptionPane.INFORMATION_MESSAGE);
                MuonTraSachDAO.lateReturn(traSach);
            }
        }

        JOptionPane.showMessageDialog(null, "Đã trả sách thành công", "Trả sách", JOptionPane.INFORMATION_MESSAGE);
        loadData();
    }// GEN-LAST:event_btnTraSachActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.isEnabled() == false) {
            return;
        }

        int index = jTable1.getSelectedRow();


        switch (jComboBox1.getSelectedIndex()) {
        case 0:
            txtTenSachMuon.setText(issued.get(index).gettSach().getTen());
            txtTenSinhVien.setText(issued.get(index).getSinhVien().getTen());
            txtNgayMuon.setText(DateUtil.convertDate(issued.get(index).getNgay_muon()));
            txtNgayHenTra.setText(DateUtil.convertDate(issued.get(index).getNgay_tra()));
            txtGhiChu.setText(issued.get(index).getGhi_chu());
            break;

        case 1:
            txtTenSachMuon.setText(returned.get(index).gettSach().getTen());
            txtTenSinhVien.setText(returned.get(index).getSinhVien().getTen());
            txtNgayMuon.setText(DateUtil.convertDate(returned.get(index).getNgay_muon()));
            txtNgayHenTra.setText(DateUtil.convertDate(returned.get(index).getNgay_tra()));
            txtGhiChu.setText(returned.get(index).getGhi_chu());
            break;
        case 2:
            txtTenSachMuon.setText(returnedLate.get(index).gettSach().getTen());
            txtTenSinhVien.setText(returnedLate.get(index).getSinhVien().getTen());
            txtNgayMuon.setText(DateUtil.convertDate(returnedLate.get(index).getNgay_muon()));
            txtNgayHenTra.setText(DateUtil.convertDate(returnedLate.get(index).getNgay_tra()));
            txtGhiChu.setText(returnedLate.get(index).getGhi_chu());
            break;
        case 3:
            txtTenSachMuon.setText(lost.get(index).gettSach().getTen());
            txtTenSinhVien.setText(lost.get(index).getSinhVien().getTen());
            txtNgayMuon.setText(DateUtil.convertDate(lost.get(index).getNgay_muon()));
            txtNgayHenTra.setText(DateUtil.convertDate(lost.get(index).getNgay_tra()));
            txtGhiChu.setText(lost.get(index).getGhi_chu());
            break;
        case 4:
            txtTenSinhVien.setText(banned.get(index).getSinhVien().getTen());
            txtGhiChu.setText(banned.get(index).getGhi_chu());
            break;
        }

        if (jComboBox1.getSelectedIndex() == 0) {
            buttonStatus(true);
        } else {
            buttonStatus(false);
        }
    }// GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_jComboBox1PropertyChange
        switch (jComboBox1.getSelectedIndex()) {
        case 0:
            jTable1.setModel(listIssuedModel);
            break;
        case 1:
            jTable1.setModel(listReturnedModel);

            buttonStatus(false);
            break;
        case 2:
            jTable1.setModel(listReturnedLateModel);

            buttonStatus(false);
            break;
        case 3:
            jTable1.setModel(listLostModel);

            buttonStatus(false);
            break;
        case 4:
            jTable1.setModel(listBannedModel);

            buttonStatus(false);
            break;
        }
    }// GEN-LAST:event_jComboBox1PropertyChange

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    // /* Set the Nimbus look and feel */
    // // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // // (optional) ">
    // /*
    // * If Nimbus (introduced in Java SE 6) is not available, stay with the default
    // * look and feel. For details see
    // * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
    // */
    // try {
    // for (javax.swing.UIManager.LookAndFeelInfo info :
    // javax.swing.UIManager.getInstalledLookAndFeels()) {
    // if ("Nimbus".equals(info.getName())) {
    // javax.swing.UIManager.setLookAndFeel(info.getClassName());
    // break;
    // }
    // }
    // } catch (ClassNotFoundException ex) {
    // java.util.logging.Logger.getLogger(DialogTraSach.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(DialogTraSach.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(DialogTraSach.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(DialogTraSach.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // }
    // // </editor-fold>

    // /* Create and display the dialog */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // DialogTraSach dialog = new DialogTraSach(new javax.swing.JFrame(), true);
    // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    // @Override
    // public void windowClosing(java.awt.event.WindowEvent e) {
    // System.exit(0);
    // }
    // });
    // dialog.setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoMat;
    private javax.swing.JButton btnChonLai;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtNgayHenTra;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtTenSachMuon;
    private javax.swing.JTextField txtTenSinhVien;
    // End of variables declaration//GEN-END:variables

    private void buttonStatus(boolean b) {
        btnTraSach.setEnabled(b);
        btnBaoMat.setEnabled(b);
    }
}
