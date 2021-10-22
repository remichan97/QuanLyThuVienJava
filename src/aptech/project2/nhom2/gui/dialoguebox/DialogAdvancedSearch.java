/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.gui.dialoguebox;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import aptech.project2.nhom2.dao.DanhMucSachDAO;
import aptech.project2.nhom2.dao.NhaXuatBanDAO;
import aptech.project2.nhom2.dao.TacGiaDAO;
import aptech.project2.nhom2.gui.maingui.FrmMainGui;
import aptech.project2.nhom2.model.ComboBoxData;
import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.model.DataTimKiem;
import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.model.TacGia;

/**
 *
 * @author Mirai
 */
public class DialogAdvancedSearch extends javax.swing.JDialog {

    /**
     * Creates new form DialogAdvancedSearch
     */

    private TacGiaDAO tacGiaDAO = new TacGiaDAO();
    private NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
    private DanhMucSachDAO danhMucSachDAO = new DanhMucSachDAO();

    private DefaultComboBoxModel<ComboBoxData> tacGiaModel;
    private DefaultComboBoxModel<ComboBoxData> danhMucSachModel;
    private DefaultComboBoxModel<ComboBoxData> nhaXuatBanModel;
    private FrmMainGui main;
    
    public DialogAdvancedSearch(java.awt.Frame parent, boolean modal, FrmMainGui main) {
        super(parent, modal);
        initComponents();

        this.main = main;

        this.setLocationRelativeTo(null);

        loadData4ComboBox();

        cmbDanhMuc.setSelectedIndex(-1);
        cmbNhaXuatBan.setSelectedIndex(-1);
        cmbTacGia.setSelectedIndex(-1);
    }

    private void loadData4ComboBox() {
        tacGiaModel = new DefaultComboBoxModel<>();
        danhMucSachModel = new DefaultComboBoxModel<>();
        nhaXuatBanModel = new DefaultComboBoxModel<>();

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbTacGia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbDanhMuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbNhaXuatBan = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tìm kiếm nâng cao");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nội dung tìm kiếm"));

        jLabel1.setText("Tên sách");

        jLabel2.setText("Tác giả");

        jLabel3.setText("Danh mục");

        jLabel4.setText("Nhà xuất bản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbNhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenSach)
                    .addComponent(cmbTacGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDanhMuc, 0, 265, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        txtTenSach.setText("");
        cmbDanhMuc.setSelectedIndex(-1);
        cmbNhaXuatBan.setSelectedIndex(-1);
        cmbTacGia.setSelectedIndex(-1);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtTenSach.getText().isEmpty() || txtTenSach.getText() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên sách cần tìm", "Chưa nhập từ khóa", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Integer danhMucID = setValue((ComboBoxData) cmbDanhMuc.getSelectedItem());
        Integer nxbID = setValue((ComboBoxData) cmbNhaXuatBan.getSelectedItem());
        Integer tacGiaID = setValue((ComboBoxData) cmbTacGia.getSelectedItem());



        // System.out.println(tacGiaID);
        // System.out.println(danhMucID);
        // System.out.println(nxbID);
        DataTimKiem data = new DataTimKiem(txtTenSach.getText(), tacGiaID, danhMucID, nxbID);
        this.main.timKiem(data);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed


    private Integer setValue(ComboBoxData selectedItem) {
        if (selectedItem != null) {
            return selectedItem.getValue();
        } else {
            return null;
        }
    }


    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(DialogAdvancedSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(DialogAdvancedSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(DialogAdvancedSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(DialogAdvancedSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the dialog */
    //     // java.awt.EventQueue.invokeLater(new Runnable() {
    //     //     public void run() {
    //     //         DialogAdvancedSearch dialog = new DialogAdvancedSearch(new javax.swing.JFrame(), true);
    //     //         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    //     //             @Override
    //     //             public void windowClosing(java.awt.event.WindowEvent e) {
    //     //                 System.exit(0);
    //     //             }
    //     //         });
    //     //         dialog.setVisible(true);
    //     //     }
    //     // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<ComboBoxData> cmbDanhMuc;
    private javax.swing.JComboBox<ComboBoxData> cmbNhaXuatBan;
    private javax.swing.JComboBox<ComboBoxData> cmbTacGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}