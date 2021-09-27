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
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class CursoMySQL implements CursoDAO{
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public int insertar(Curso curso) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            //Instruccion SQL
            st = con.createStatement();
            String instruccion = "INSERT INTO curso(codigo,nombre,creditos,especialidad,nivel,"
                    + "descripcion,creditosRequeridos,estado,activo) "
                    + "VALUES(?,?,?,?,?,?,?,?,1)";
            ps = con.prepareStatement(instruccion);        
            //////////////////////////////////////
            ps = con.prepareStatement(instruccion);
            ps.setString(1, curso.getCodigo());
            ps.setString(2, curso.getNombre());
            ps.setFloat(3, curso.getCreditos());
            ps.setString(4, curso.getEspecialidad());
            ps.setInt(5, curso.getNivel());
            ps.setString(6, curso.getDescripcion());
            ps.setFloat(7,curso.getCreditosRequeridos());
            ps.setInt(8, curso.getEstado());
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
    public int modificar(Curso curso) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE curso SET nombre = ?, creditos = ?,"
                    + "especialidad = ?, nivel=?, descripcion=?, creditosRequeridos=?, estado=? WHERE codigo=?";
            ps = con.prepareStatement(instruccion);
            ps.setString(1, curso.getNombre());
            ps.setFloat(2, curso.getCreditos());
            ps.setString(3, curso.getEspecialidad());
            ps.setInt(4, curso.getNivel());
            ps.setString(5, curso.getDescripcion());
            ps.setFloat(6,curso.getCreditosRequeridos());
            ps.setInt(7, curso.getEstado());
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
    public int eliminar(int codigo) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE activo=0 WHERE codigo=?";
            ps = con.prepareStatement(instruccion);
            ps.setInt(1, codigo);
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
    public ArrayList<Curso> listarTodos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            st = con.createStatement();
            String instruccion = "SELECT * FROM curso WHERE activo=1";
            rs = st.executeQuery(instruccion);
            while(rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                float  creditos = rs.getFloat("creditos");
                String especialidad = rs.getString("especialidad");
                int nivel = rs.getInt("nivel");
                String descripcion = rs.getString("descripcion");
                float creditosRequeridos = rs.getFloat("creditosRequeridos");
                int estado = rs.getInt("estado");
                Curso curso = new Curso(codigo, nombre, creditos, especialidad, 
                        nivel, descripcion, creditosRequeridos,estado);
                curso.setActivo(true);
                cursos.add(curso);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {st.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return cursos;
    }
    

}
