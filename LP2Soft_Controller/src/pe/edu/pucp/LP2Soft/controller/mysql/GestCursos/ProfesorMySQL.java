/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestCursos;

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

    @Override
    public int insertar(Profesor profesor) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            //Instruccion SQL
            st = con.createStatement();
            String instruccion = "INSERT INTO profesor(idProfesor,nombre,correo,descripcion,"
                    + "activo) "
                    + "VALUES(?,?,?,?,1)";
            ps = con.prepareStatement(instruccion);        
            //////////////////////////////////////
            ps = con.prepareStatement(instruccion);
            ps.setInt(1, profesor.getIdProfesor());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getCorreo());
            ps.setString(4, profesor.getDescripcion());
            resultado = ps.executeUpdate();
            
                    
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                st.close();
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE curso SET nombre = ?, correo = ?,"
                    + "descripcion=? WHERE codigo=?";
            ps = con.prepareStatement(instruccion);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getCorreo());
            ps.setString(3, profesor.getDescripcion());
            resultado = ps.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                st.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int eliminar(int profesor) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE activo=0 WHERE idProfesor=?";
            ps = con.prepareStatement(instruccion);
            ps.setInt(1,profesor);
            resultado = ps.executeUpdate();
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            st = con.createStatement();
            String instruccion = "SELECT * FROM profesor WHERE activo=1";
            rs = st.executeQuery(instruccion);
            while(rs.next()) {
                int codigo = rs.getInt("idProfesor");
                String nombre = rs.getString("nombre");
                String  correo = rs.getString("correo");
                String descripcion = rs.getString("descripcion");
                Profesor profesor = new Profesor(codigo, nombre, correo, descripcion); 
                        
                profesor.setActivo(true);
                profesores.add(profesor);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {st.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return profesores;
    }
    
}
