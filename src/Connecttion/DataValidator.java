/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connecttion;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author NamHV
 */
public class DataValidator {
    public static void ValidateEmpty(JTextField field, StringBuilder sb, String errorMessage)
    {
        if(field.getText().equals(""))
        {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
            
        }else{
            field.setBackground(Color.WHITE);
        }
               
    }
    
     public static void ValidateEmpty(JPasswordField field, StringBuilder sb, String errorMessage)
    {
        String pass = new String(field.getPassword());
        if(pass.equals(""))
        {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
            
        }else{
            field.setBackground(Color.WHITE);
        }
               
    }
}
