/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.gui.dialoguebox;

import java.util.List;

import javax.swing.DefaultListModel;

import aptech.project2.nhom2.dao.DanhMucSachDAO;
import aptech.project2.nhom2.dao.NhaXuatBanDAO;
import aptech.project2.nhom2.dao.TacGiaDAO;
import aptech.project2.nhom2.model.ComboBoxData;
import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.model.TacGia;

/**
 *
 * @author Mirai
 */

public class DialogDanhMuc extends javax.swing.JDialog {

    /**
     * Creates new form DialogDanhMuc
     */
    private static int option;

    private TacGiaDAO tacGiaDAO = new TacGiaDAO();
    private NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
    private DanhMucSachDAO danhMucSachDAO = new DanhMucSachDAO();

    private DefaultListModel tacGiaModel = new DefaultListModel<>();
    private DefaultListModel nxbModel = new DefaultListModel<>();
    private DefaultListModel danhMucSachModel = new DefaultListModel<>();
    
    public DialogDanhMuc(java.awt.Frame parent, boolean modal, int option) {
        super(parent, modal);
        initComponents();
        
        loadData(option);
        
        switch (option) {
            case 1:
                this.setTitle("Danh sách tác giả");
                jLabel2.setText("Danh sách tác giả");
                option = DialogDanhMuc.option;
                listDanhMuc.setModel(tacGiaModel);
                break;
            case 2:
                this.setTitle("Danh mục sách");
                jLabel2.setText("Danh mục sách hiện có");
                option = DialogDanhMuc.option;
                listDanhMuc.setModel(danhMucSachModel);
                break;
            case 3:
                this.setTitle("Danh mục nhà xuất bản");
                jLabel2.setText("Danh sách nhà xuất bản");
                option = DialogDanhMuc.option;
                listDanhMuc.setModel(nxbModel);
                break;
        }
        this.setLocationRelativeTo(null);

    }

    private void loadData(int option) {
        switch (option) {
            case 1:
                List<TacGia> tacGia = tacGiaDAO.findAll();
                tacGia.forEach(it -> {
                    tacGiaModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
                });
                break;
            case 2:
                List<DanhMucSach> danhMucSach = danhMucSachDAO.findAll();
                danhMucSach.forEach(it -> {
                    danhMucSachModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
                });
                break;
            case 3:
                List<NhaXuatBan> nhaXuatBans = nhaXuatBanDAO.findAll();
                nhaXuatBans.forEach(it -> {
                    nxbModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
                });
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnViewBooks = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDanhMuc = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jLabel1.setText("Tên");

        btnAdd.setText("Thêm");

        btnEdit.setText("Sửa");

        btnDelete.setText("Xóa");

        btnViewBooks.setText("Xem sách");

        jLabel2.setText("Danh sách");

        jScrollPane1.setViewportView(listDanhMuc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewBooks))
                            .addComponent(jLabel2))
                        .addGap(0, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnViewBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogDanhMuc dialog = new DialogDanhMuc(new javax.swing.JFrame(), true, option);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnViewBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> listDanhMuc;
    // End of variables declaration//GEN-END:variables
}
