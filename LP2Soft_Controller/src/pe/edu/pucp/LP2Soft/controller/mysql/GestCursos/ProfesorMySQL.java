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
            profesor.setIdProfesor(cs.getInt("_idProfesor"));
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
    public ArrayList<Profesor> listarProfesorNombre(String nombre) {
       ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PROFESOR_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("idProfesor"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCalificacion(rs.getFloat("calificacion"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setDescripcion(rs.getString("descripcion"));
                profesor.setFoto(rs.getBytes("foto"));
                profesor.setSumatoriaResenias(rs.getInt("sumatoriaResenias"));
                profesor.setCantidadResenias(rs.getInt("cantidadResenias"));
                //System.out.println(profesor.getIdProfesor());
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
    
    @Override
    public Profesor mostrarProfesor(int idProfesor) {
        Profesor profesor = new Profesor();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MOSTRAR_PROFESOR(?)}");
            cs.setInt("_idProfesor",idProfesor);
            rs = cs.executeQuery();
            while(rs.next()) {
                
                profesor.setIdProfesor(idProfesor);
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCalificacion(rs.getFloat("calificacion"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setDescripcion(rs.getString("descripcion"));
                profesor.setFoto(rs.getBytes("foto"));
                profesor.setSumatoriaResenias(rs.getInt("sumatoriaResenias"));
                profesor.setCantidadResenias(rs.getInt("cantidadResenias"));
                profesor.setActivo(rs.getBoolean("activo"));
                
            } 
            
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return profesor;
    }
    
    @Override
    public ArrayList<Curso> listarCursoProfesor(int idProfesor) {
       ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSO_PROFESOR(?)}");
            cs.setInt("_idProfesor", idProfesor);
            rs = cs.executeQuery();
            while(rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigo(rs.getString("CodigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setNivel(rs.getInt("nivel"));
                curso.setCreditos(rs.getFloat("creditos"));
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

    @Override
    public ArrayList<Profesor> listarProfesorXCurso(int idCurso) {
        ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTA_PROFESORES_CURSO(?)}");
            cs.setInt("_idCurso", idCurso);
            rs = cs.executeQuery();
            while(rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("idProfesor"));
                profesor.setNombre(rs.getString("p.nombre"));
                profesor.setCalificacion(rs.getFloat("calificacion"));
                profesor.setCorreo(rs.getString("correo"));
                profesor.setDescripcion(rs.getString("descripcion"));
                profesor.setFoto(rs.getBytes("foto"));
                profesor.setSumatoriaResenias(rs.getInt("sumatoriaResenias"));
                profesor.setCantidadResenias(rs.getInt("cantidadResenias"));
                System.out.println(profesor.getIdProfesor());
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
