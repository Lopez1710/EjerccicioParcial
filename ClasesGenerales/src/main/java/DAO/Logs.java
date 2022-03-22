/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import com.lopez.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class Logs {
    ConexionAMYSQL Con = new ConexionAMYSQL();
    Connection conexion = Con.getCon();
    
    
    
    public ArrayList <Estudiante> ListadoEstudiantes(String user ,String pass){
        
        ArrayList<Estudiante> listado=null;
        
        try {
            listado=new ArrayList<Estudiante>();
            
            CallableStatement cb = conexion.prepareCall("{call SP_S_LOG(?,?)}");
            cb.setString("PUser", user);
            cb.setString("PPass", pass);
            
            ResultSet resultado = cb.executeQuery();
            
            
            
            while(resultado.next()){
                Estudiante es=new Estudiante();
                es.setNombre(resultado.getString("Nombre"));
                es.setApellido(resultado.getString("Apellido"));
                es.setUser(resultado.getString("Usuario"));
                es.setPass(resultado.getString("Pass"));
                listado.add(es);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: "+e);
        }

        return listado;
    }
}
