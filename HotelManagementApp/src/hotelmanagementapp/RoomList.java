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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class RoomList {
    public void getInfo(javax.swing.JTable table){
        String host ="jdbc:mysql://localhost:3306/ap_db";
        String username="root";
        String pass="thanducsu";
        Connection con = null;
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(host,username,pass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM ap_db.room;");
            String[] columnNames = {"Mã phòng", "Loại phòng", "Tình trạng phòng", "Giá"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0){
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

            table.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(RoomList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

