/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class RoomManagement extends javax.swing.JFrame {

    /**
     * Creates new form RoomManagement
     * @param conn
     */
    public RoomManagement(Connection connGlobal) {
        initComponents();
        jButtonDelete.setEnabled(false);
        jButtonSaveChange.setEnabled(false);
        jButtonAdd.setEnabled(true);
        conn = connGlobal;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM 8gQHxi21p3.room;");
            String[] columnNames = {"Mã phòng", "Loại phòng", "Tình trạng phòng", "Giá"};
            DefaultTableModel tableModel;
            tableModel = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };

            while (rs.next()) {
                String idroom = rs.getString("idroom");
                String type = rs.getString("type");
                String status = rs.getString("status");
                String price = rs.getString("price");
                String status_str;
                
                if (status.equals("0")) {
                    status_str = "Chưa đặt";
                }
                else {
                    status_str = "Đã đặt";
                }

                // create a single array of one row's worth of data
                String[] data = { idroom, type, status_str, price } ;

                // and add this row of data into the table model
                tableModel.addRow(data);
            }

            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(RoomList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection conn;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextRoomNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextRoomType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextRoomPrice = new javax.swing.JTextField();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonSaveChange = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã phòng");

        jTextRoomNo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel2.setText("Loại phòng");

        jLabel3.setText("Tình trạng phòng");

        jLabel4.setText("Giá");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa đặt", "Đã đặt" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Loại phòng", "Tình trạng phòng", "Giá phòng"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Mã phòng");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Loại phòng");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Tình trạng phòng");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Giá phòng");
        }

        jButtonAdd.setText("Thêm");
        jButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSaveChange.setText("Lưu");
        jButtonSaveChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveChange.setEnabled(false);
        jButtonSaveChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChangeActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Xoá");
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaveChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd)
                            .addComponent(jButtonSaveChange)
                            .addComponent(jButtonDelete))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChangeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonSaveChangeActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int rowIndex = jTable1.getSelectedRow();
        String idroom = (String) jTable1.getValueAt(rowIndex, 0);
        // For Debuging only
        System.out.println(idroom);
        
        try {
            Statement stmt = conn.createStatement();
            String delQuery = "DELETE FROM `ap_db`.`room` WHERE (`idroom` = '"
                    + idroom + "')";
            stmt.execute(delQuery);
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.removeRow(rowIndex);
            
            
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        String idroom = jTextRoomNo.getText();
        String type = jTextRoomType.getText();
        String status = jComboBoxStatus.getSelectedItem().toString();
        String price = jTextRoomPrice.getText();
        String[] data = { idroom, type, status, price };
        
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.addRow(data);
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String addQuery = "INSERT INTO `ap_db`.`room` (`idroom`, `type`, `status`, `price`)"
                + " VALUES ('" + jTextRoomNo.getText() + "', '"
                + jTextRoomType.getText() + "', '"
                + jComboBoxStatus.getSelectedIndex() + "', '"
                + jTextRoomPrice.getText() + "')";
        
        ResultSet rs = null;
        try {
            if(stmt.executeUpdate(addQuery) > 0) {
//                room.getInfo(jTable1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextRoomNo.setText("");
        jTextRoomType.setText("");
        jTextRoomPrice.setText("");
        jComboBoxStatus.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jButtonSaveChange.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonAdd.setEnabled(false);
        int rowIndex = jTable1.getSelectedRow();
        String idroom = (String) jTable1.getValueAt(rowIndex, 0);
        String roomType = (String) jTable1.getValueAt(rowIndex, 1);
        String status = (String) jTable1.getValueAt(rowIndex, 2);
        String roomPrice = (String) jTable1.getValueAt(rowIndex, 3);
        
        jTextRoomNo.setText(idroom);
        jTextRoomType.setText(roomType);
        jTextRoomPrice.setText(roomPrice);
        if (status.equals("Chưa đặt")){
            jComboBoxStatus.setSelectedIndex(0);
        }
        else jComboBoxStatus.setSelectedIndex(1);
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSaveChange;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextRoomNo;
    private javax.swing.JTextField jTextRoomPrice;
    private javax.swing.JTextField jTextRoomType;
    // End of variables declaration//GEN-END:variables
}
