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
            cs = con.prepareCall("{call INSERTAR_ASESOR(?,?,?,?)}");
            cs.registerOutParameter("_idAsesor", java.sql.Types.INTEGER);
            cs.setFloat("_calificacion", a.getCalificacion());
            cs.setFloat("_precioPorHora", a.getPrecioPorHora());
            cs.setString("_ubicacion", String.valueOf(a.getUbicacion()));
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
            cs.setInt("_idAsesor", a.getIdAsesor());
            cs.setFloat("_calificacion", a.getCalificacion());
            cs.setFloat("_precioPorHora",a.getPrecioPorHora());
            cs.setString("_ubicacion", String.valueOf(a.getUbicacion()));
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
        ArrayList<Asesor> asesores = new ArrayList<>();
        boolean resultados=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_ASESORES()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                float precioPorHora = rs.getFloat("precioPorHora");
                //String ubicacion = rs.getString("ubicacion");

                Asesor asesor = new Asesor();
                asesor.setPrecioPorHora(precioPorHora);
                asesores.add(asesor);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return asesores;
    }    
}
