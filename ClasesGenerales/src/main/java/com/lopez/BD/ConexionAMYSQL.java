/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lopez.BD;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author dead1
 */
public class ConexionAMYSQL {
    private static Connection Con=null;
    public Connection getCon(){
        try {
            String url="jdbc:mysql://localhost:3306/estudiante";
            String user="Lopez";
            String password = "root";
            
            Con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error"+e.toString());
        }
        return Con;
    }
}
