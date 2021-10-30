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
    CallableStatement cs;
    @Override
    public int insertar(Curso curso) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CURSO(?,?,?,?,?,?,?,?)}");
            cs.setString("_idCurso",curso.getCodigo());
            cs.setString("_nombre",curso.getNombre());
            cs.setFloat("_creditos", curso.getCreditos());
            cs.setString("_especialidad",curso.getEspecialidad());
            cs.setInt("_nivel", curso.getNivel());
            cs.setString("_descripcion",curso.getDescripcion());
            cs.setFloat("_creditosRequeridos", curso.getCreditosRequeridos());
            cs.setInt("_estado",curso.getEstado());
            cs.executeUpdate();
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
    public int modificar(Curso curso) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CURSO(?,?,?,?,?,?,?,?)}");
            cs.setString("_idCurso",curso.getCodigo());
            cs.setString("_nombre",curso.getNombre());
            cs.setString("_descripcion",curso.getDescripcion());
            cs.setString("_especialidad",curso.getEspecialidad());
            cs.setFloat("_creditos", curso.getCreditos());
            cs.setInt("_nivel", curso.getNivel());
            cs.setFloat("_creditosRequeridos", curso.getCreditosRequeridos());
            cs.setInt("_estado",curso.getEstado());
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
    public int eliminar(String codigoCurso) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_CURSO(?)}");
            cs.setString("_idCurso",codigoCurso);
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
    public ArrayList<Curso> listarTodos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSOS()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                String codigo = rs.getString("idCurso");
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
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return cursos;
    }
    

}
