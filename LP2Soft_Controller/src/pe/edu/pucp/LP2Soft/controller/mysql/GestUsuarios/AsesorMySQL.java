/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;

import java.sql.Connection; // No confundir
import java.sql.ResultSet; // No confundir
import java.sql.PreparedStatement; // No confundir
import java.sql.Statement; // No confundir
import java.sql.DriverManager;  // No confundir
import java.sql.CallableStatement;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;

public class AsesorMySQL implements AsesorDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;
    
    @Override
    public int insertar(Asesor a) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_ASESOR(?,?,?,?,?)}");
            cs.registerOutParameter("_idAsesor", java.sql.Types.INTEGER);
            //cs.setInt("_fidUsuario", a.getUser().getCodigoPUCP());  
            cs.setFloat("_calificacion", a.getCalificacion());
            cs.setFloat("_precioPorHora", a.getPrecioPorHora());
            //cs.setString("_ubicacion", a.getUbicacion());
            cs.executeUpdate();
            resultado = cs.getInt("_idAsesor");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Asesor a) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MODIFICAR_ASESOR(?,?,?,?)}");
            //cs.setInt("_idAsesor", a.getIdAsesor);
            cs.setFloat("_calificacion", a.getCalificacion());
            cs.setFloat("_precioPorHora",a.getPrecioPorHora());
            //cs.setString("_ubicacion", a.getUbicacion());
            resultado = cs.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idAsesor) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_ASESOR(?)}");
            cs.setInt("_idAsesor", idAsesor);
            resultado = cs.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Asesor> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asesor mostrar(int idAsesor, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
