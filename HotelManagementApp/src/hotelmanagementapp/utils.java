/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementapp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author admin
 */
public class utils {
    public static Connection conn;
    public static String username;
    public static Dimension dim;
    public static String mySQLDateFormat;
    static {
        System.out.println("Establish connect to db");
        String url = "jdbc:mysql://127.0.0.1:3306/ap_db";
        String user = "root";
        String password = "thanducsu";
        conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connect successfully!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        dim = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Connection getConnection() {
        return conn;
    }
    
    public static void setUsername(String name) {
        username = name;
    }
    
    public static String getUsername() {
        return username;
    }
    
    public static Dimension getScreenSize() {
        return dim;
    }
    
    public static ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static ResultSet executeQueryWithPreparedStatement(
            String preparedQuery,
            String[] inputString) throws SQLException 
    {
        PreparedStatement st;

        st = conn.prepareStatement(preparedQuery);
        for (int i = 0; i < inputString.length; i++) {
            st.setString(i+1, inputString[i]);
        }
        
        return st.executeQuery();
    }
    
    public static void tableRender(JTable table,
                                   String[] tb_columns,
                                   String[] db_columns,
                                   ResultSet rs) 
    {
        DefaultTableModel tableModel;
        tableModel = new DefaultTableModel(tb_columns, 0){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            while (rs.next()) {
                int no_columns = tb_columns.length;
                String[] data = new String[no_columns];
                for (int i=0; i<no_columns; i++) {
                    data[i] = rs.getString(db_columns[i]);
                }
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setModel(tableModel);
    }
    
    public static String convertJavaUtilDateToString(Date d, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);  
        return dateFormat.format(d);
    }
    
    public static void setMySQLDateFormat(String format) {
        mySQLDateFormat = format;
    }
    
    public static String getMySQLDateFormat() {
        return mySQLDateFormat;
    }
}
