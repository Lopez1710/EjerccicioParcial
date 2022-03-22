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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class Estudiantes {
    ConexionAMYSQL Con = new ConexionAMYSQL();
    Connection conexion = Con.getCon();
    public ArrayList <Estudiante> ListadoEstudiantes(){
        
        ArrayList<Estudiante> listado=null;
        
        try {
            listado=new ArrayList<Estudiante>();
            
            CallableStatement cb = conexion.prepareCall("{call SP_S_ESTUDIANTE}");
            
            ResultSet resultado = cb.executeQuery();
            
            
            while(resultado.next()){
                Estudiante es=new Estudiante();
                es.setNombre(resultado.getString("Nombre"));
                es.setApellido(resultado.getString("Apellido"));
                listado.add(es);
            }
        } catch (Exception e) {
        }

        return listado;
    }
    
    public void AgregarEstudiante(Estudiante es){
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_ESTUDIANTE(?,?,?,?)}");
            cb.setString("PNombre", es.getNombre());
            cb.setString("PApellido", es.getApellido());
            cb.setString("PUser",es.getUser());
            cb.setString("PPassword", es.getPass());
            
            
            cb.execute();
            JOptionPane.showMessageDialog(null, "Estudiante Agregado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error: "+ex);
        }
            
    }
}
