/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.lopez.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dead1
 */
public class Notas {
        ConexionAMYSQL Con = new ConexionAMYSQL();
    Connection conexion = Con.getCon();
    /*public ArrayList <Nota> ListadoNotas(){
        
        ArrayList<Nota> listado=null;
        
        try {
            listado=new ArrayList<Nota>();
            
            CallableStatement cb = conexion.prepareCall("{call SP_S_NOTA}");
            
            ResultSet resultado = cb.executeQuery();
            
            
            while(resultado.next()){
                Nota es=new Nota();
                es.setNota(resultado.getString("nota"));
                es.setNombre(resultado.getString("Nombre"));
                es.setNombreMateria(resultado.getString("NombreMateria"));
                listado.add(es);
            }
        } catch (Exception e) {
        }

        return listado;
    }*/
    
    public ArrayList <NotaVM> ListadoNotas(){
        
        ArrayList<NotaVM> listado=null;
        
        try {
            listado=new ArrayList<NotaVM>();
            
            CallableStatement cb = conexion.prepareCall("{call SP_S_NOTA}");
            
            ResultSet resultado = cb.executeQuery();
            
            
            while(resultado.next()){
                NotaVM es=new NotaVM();
                es.setNota(resultado.getString("nota"));
                es.setNombre(resultado.getString("Nombre"));
                es.setNombremateria(resultado.getString("NombreMateria"));
                listado.add(es);
            }
        } catch (Exception e) {
        }

        return listado;
    }
}
