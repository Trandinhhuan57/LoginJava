/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Connecttion.Conn;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NamHV
 */
public class User {
    public UserDTO login(String userName, String password) throws Exception {
        String sql = "Select UserName, Password, Email from Users where UserName = ? and Password = ?";

        try (Connection con = Conn.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setUserName(userName);
                    if (rs.getString("Email")!=null) {
                        user.setEmail(rs.getString("Email"));
                    }
                    return user;
                }
            }
        }
        return null;
    }
    
    public boolean register(UserDTO user) throws Exception {
        String sql = "insert into Users (UserName, Password, Email)  values(?,?,?)";

        try (Connection con = Conn.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
