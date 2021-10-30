/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestCursos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.ProfesorDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;

public class ProfesorMySQL implements ProfesorDAO{
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    CallableStatement cs;
    @Override
    public int insertar(Profesor profesor) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PROFESOR(?,?,?,?)}");
            cs.registerOutParameter("_idProfesor",java.sql.Types.INTEGER);
            cs.setString("_nombre",profesor.getNombre());
            cs.setString("_correo",profesor.getCorreo());
            cs.setString("_descripcion",profesor.getDescripcion());
            cs.executeUpdate();
            profesor.setidProfesor(cs.getInt("_idProfesor"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                cs.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Profesor profesor) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_PROFE(?,?,?,?,?)}");
            cs.setInt("_idProfesor",profesor.getIdProfesor());
            cs.setString("_nombre",profesor.getNombre());
            cs.setString("_correo",profesor.getCorreo());
            cs.setString("_descripcion",profesor.getDescripcion());
            cs.setDouble("_calificacion",profesor.getCalificacion());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                cs.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int eliminar(int codigoProfesor) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_PROFESOR(?)}");
            cs.setInt("_idProfesor", codigoProfesor);
            resultado = cs.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {ps.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Profesor> listarTodos() {
       ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PROFESORES()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                int idProfesor = rs.getInt("idProfesor");
                String nombre = rs.getString("nombre");
                String  correo = rs.getString("correo");
                String descripcion = rs.getString("descripcion");
                float calificacion = rs.getFloat("calificacion");
                Profesor profesor = new Profesor(idProfesor, nombre, correo, descripcion); 
                profesor.setActivo(true);
                profesor.setCalificacion(calificacion);
                profesores.add(profesor);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return profesores;
    }
    
}
