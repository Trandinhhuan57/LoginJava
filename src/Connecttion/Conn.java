/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connecttion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NamHV
 */
public class Conn {
    public static Connection OpenConnection()throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connUrl = "jdbc:sqlserver://localhost;database=LoginJava";
        String username = "sa";
        String Password = "abc123!@#";
        Connection conn = DriverManager.getConnection(connUrl, username, Password);
        
        return conn;        
    }
}
