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
    public static Dimension dim;
    public static String mySQLDateFormat;
    public static String hostname;
    public static String db_name;
    public static String username;
    public static String password;
    
    public static String user; // for mainform username display only
    
    public static void initConnection() {
        System.out.println("Establish connect to db");
        String url = hostname + db_name;
        conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connect successfully!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        dim = Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    public static void setUser(String name) { user = name; }
    public static String getUser() { return user; }
    
    public static void  setHostname(String name) { hostname = name; }
    public static String getHostname() { return hostname; }
    
    public static void setDBName(String name) { db_name = name; }
    public static String getDBName () { return db_name; }
    
    public static void setUsername(String name) { username = name; }
    public static String getUserName() { return username; }
    
    public static void setPassword(String pass) { password = pass; }
    public static String getPassword() { return password; }

    public static Connection getConnection() { return conn; }
    
    public static Dimension getScreenSize() { return dim; }
    
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
    
    public static void updateQueryWithPreparedStatment(String preparedQuery, String[] inputString) {
        try {
            PreparedStatement st = conn.prepareStatement(preparedQuery);
            for (int i = 0; i < inputString.length; i++) {
                st.setString(i+1, inputString[i]);
            }
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public static void setMySQLDateFormat(String format) { mySQLDateFormat = format; }
    public static String getMySQLDateFormat() { return mySQLDateFormat; }
}
