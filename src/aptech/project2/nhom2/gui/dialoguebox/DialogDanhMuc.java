/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.project2.nhom2.gui.dialoguebox;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import aptech.project2.nhom2.dao.DanhMucSachDAO;
import aptech.project2.nhom2.dao.NhaXuatBanDAO;
import aptech.project2.nhom2.dao.TacGiaDAO;
import aptech.project2.nhom2.dao.ThongTinSachDAO;
import aptech.project2.nhom2.model.ComboBoxData;
import aptech.project2.nhom2.model.DanhMucSach;
import aptech.project2.nhom2.model.NhaXuatBan;
import aptech.project2.nhom2.model.TacGia;
import aptech.project2.nhom2.model.ThongTinSach;

/**
 *
 * @author Mirai
 */

public class DialogDanhMuc extends javax.swing.JDialog {

    /**
     * Creates new form DialogDanhMuc
     */
    private int choice;
    private int id;

    private TacGiaDAO tacGiaDAO = new TacGiaDAO();
    private NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
    private DanhMucSachDAO danhMucSachDAO = new DanhMucSachDAO();
    private ThongTinSachDAO thongTinSachDAO = new ThongTinSachDAO();

    private List<TacGia> tacGia;
    private List<DanhMucSach> danhMucSach;
    private List<NhaXuatBan> nhaXuatBans;

    private DefaultListModel<ComboBoxData> tacGiaModel = new DefaultListModel<>();
    private DefaultListModel<ComboBoxData> nxbModel = new DefaultListModel<>();
    private DefaultListModel<ComboBoxData> danhMucSachModel = new DefaultListModel<>();

    public DialogDanhMuc(java.awt.Frame parent, boolean modal, int option) {
        super(parent, modal);
        initComponents();

        loadData(option);

        switch (option) {
        case 1:
            this.setTitle("Danh sách tác giả");
            jLabel2.setText("Danh sách tác giả");
            choice = option;
            listDanhMuc.setModel(tacGiaModel);
            break;
        case 2:
            this.setTitle("Danh mục sách");
            jLabel2.setText("Danh mục sách hiện có");
            choice = option;
            listDanhMuc.setModel(danhMucSachModel);
            break;
        case 3:
            this.setTitle("Danh mục nhà xuất bản");
            jLabel2.setText("Danh sách nhà xuất bản");
            choice = option;
            listDanhMuc.setModel(nxbModel);
            break;
        }
        this.setLocationRelativeTo(null);

    }

    private void loadData(int option) {
        switch (option) {
        case 1:
            tacGia = tacGiaDAO.findAll();
            tacGia.forEach(it -> {
                tacGiaModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
            });
            break;
        case 2:
            danhMucSach = danhMucSachDAO.findAll();
            danhMucSach.forEach(it -> {
                danhMucSachModel.addElement(new ComboBoxData(it.getId(), it.getTen()));
            });
            break;
        case 3:
            nhaXuatBans = nhaXuatBanDAO.findAll();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
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
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnViewBooks.setText("Xem sách");
        btnViewBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBooksActionPerformed(evt);
            }
        });

        jLabel2.setText("Danh sách");

        listDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listDanhMucMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listDanhMuc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1))
                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEdit)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnViewBooks))
                                        .addComponent(jLabel2)).addGap(0, 112, Short.MAX_VALUE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnAdd)
                        .addComponent(btnEdit).addComponent(btnDelete).addComponent(btnViewBooks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listDanhMucMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listDanhMucMousePressed
        List<ComboBoxData> data = listDanhMuc.getSelectedValuesList();
        id = data.get(0).getValue();
        jTextField1.setText(data.get(0).toString());

    }// GEN-LAST:event_listDanhMucMousePressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên danh mục cần thêm", "Thiếu dữ liệu",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        switch (choice) {
        case 1:
            TacGia test = tacGia.stream().filter(it -> it.getTen().equals(jTextField1.getText())).findAny()
                    .orElse(null);
            if (test != null) {
                JOptionPane.showMessageDialog(null, "Danh mục đã tồn tại", "Trùng dữ liệu",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            tacGiaDAO.addNew(new TacGia(jTextField1.getText()));
            tacGiaModel.setSize(0);
            jTextField1.setText("");
            loadData(choice);
            break;

        case 2:
            DanhMucSach testDanhMucSach = danhMucSach.stream().filter(it -> it.getTen().equals(jTextField1.getText()))
                    .findAny().orElse(null);
            if (testDanhMucSach != null) {
                JOptionPane.showMessageDialog(null, "Danh mục đã tồn tại", "Trùng dữ liệu",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            danhMucSachDAO.addNew(new DanhMucSach(jTextField1.getText()));
            danhMucSachModel.setSize(0);
            jTextField1.setText("");
            loadData(choice);
            break;
        case 3:
            NhaXuatBan testNhaXuatBan = nhaXuatBans.stream().filter(it -> it.getTen().equals(jTextField1.getText()))
                    .findAny().orElse(null);
            if (testNhaXuatBan != null) {
                JOptionPane.showMessageDialog(null, "Danh mục đã tồn tại", "Trùng dữ liệu",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            nhaXuatBanDAO.addNew(new NhaXuatBan(jTextField1.getText()));
            nxbModel.setSize(0);
            jTextField1.setText("");
            loadData(choice);
            break;
        }

    }// GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        if (listDanhMuc.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một danh mục tại danh sách để sửa thông tin",
                    "Chưa chọn danh mục", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        switch (choice) {
        case 1:
            tacGiaDAO.update(new TacGia(id, jTextField1.getText()));
            jTextField1.setText("");
            tacGiaModel.setSize(0);
            loadData(choice);
            break;
        case 2:
            danhMucSachDAO.update(new DanhMucSach(id, jTextField1.getText()));
            jTextField1.setText("");
            danhMucSachModel.setSize(0);
            loadData(choice);
            break;
        case 3:
            nhaXuatBanDAO.update(new NhaXuatBan(id, jTextField1.getText()));
            jTextField1.setText("");
            nxbModel.setSize(0);
            loadData(choice);
            break;
        }

    }// GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        if (listDanhMuc.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một danh mục tại danh sách để xóa thông tin",
                    "Chưa chọn danh mục", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa danh mục đã chọn?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION) == 0) {
            switch (choice) {
            case 1:
                tacGiaDAO.delete(id);
                tacGiaModel.setSize(0);
                loadData(choice);
                break;
            case 2:
                danhMucSachDAO.delete(id);
                danhMucSachModel.setSize(0);
                loadData(choice);
                break;
            case 3:
                nhaXuatBanDAO.delete(id);
                nxbModel.setSize(0);
                loadData(choice);
                break;

            }
        }

    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewBooksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewBooksActionPerformed
        if (listDanhMuc.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn một danh mục tại danh sách để xem thông tin sách liên quan", "Chưa chọn danh mục",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        switch (choice) {
        case 1:
            List<ThongTinSach> sachtg = thongTinSachDAO.findByTacGia(id);
            DialogSachView frm = new DialogSachView(null, true, sachtg);
            frm.setVisible(true);
            break;
        case 2:
            List<ThongTinSach> sachs = thongTinSachDAO.findByDanhMuc(id);
            DialogSachView frmDanhMuc = new DialogSachView(null, true, sachs);
            frmDanhMuc.setVisible(true);
            break;
        case 3:
            List<ThongTinSach> sachnxb = thongTinSachDAO.findByNXB(id);
            DialogSachView frmNXB = new DialogSachView(null, true, sachnxb);
            frmNXB.setVisible(true);
            break;
        }
    }// GEN-LAST:event_btnViewBooksActionPerformed

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
    // java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(DialogDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE,
    // null,
    // ex);
    // }
    // // </editor-fold>

    // /* Create and display the dialog */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // DialogDanhMuc dialog = new DialogDanhMuc(new javax.swing.JFrame(), true,
    // option);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnViewBooks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<ComboBoxData> listDanhMuc;
    // End of variables declaration//GEN-END:variables
}
