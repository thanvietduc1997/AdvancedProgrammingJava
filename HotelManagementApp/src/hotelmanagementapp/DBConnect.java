/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBConnect {
    private String host ="jdbc:mysql://aphotelmanagement.mysql.database.azure.com:3306/ap_db?useSSL=true&requireSSL=false&serverTimezone=UTC";
    private String username="hoteladmin@aphotelmanagement";
    private String pass="Abcd1234";
    private Connection conn;
    public DBConnect() {
        conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(host,username,pass);
            System.out.println("Connect successfully!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection() {
        return conn;
    }
}
