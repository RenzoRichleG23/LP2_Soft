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
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

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
            cs = con.prepareCall("{call LISTAR_PROFESORES_CURSO(?)}");
            cs.setInt("_idCurso", idCurso);
            rs = cs.executeQuery();
            while(rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("idProfesor"));
                profesor.setNombre(rs.getString("p.nombre"));
                System.out.println(profesor.getNombre());
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
    
    @Override
    public int insertarReseniaProfesor(Resenia re) {
        int resultado=-1;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_RESENIA_PROFESOR(?,?,?,?,?,?)}");
            cs.registerOutParameter("_resultado", java.sql.Types.INTEGER);
            cs.setInt("_idUsuario", re.getUsuario().getIdUsuario());
            cs.setString("_descripcion", re.getContenido());
            cs.setInt("_prioridad", re.getPrioridad());
            cs.setInt("_fidProfesorReseniado", re.getProfesor().getIdProfesor());
            cs.setInt("_calificacion", re.getCalificacion());
            cs.executeUpdate();
            resultado = cs.getInt("_resultado");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
    @Override
    public ArrayList<Resenia> listarReseniasProfesor(int fidProfesor) {
        ArrayList<Resenia> resenias = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_RESENIAS_PROFESOR(?)}");
            cs.setInt("_idProfesor", fidProfesor);
            rs = cs.executeQuery();
            while(rs.next()) {
                Resenia resenia = new Resenia();
                resenia.setIdPost(rs.getInt("idPost"));
                resenia.setUsuario(new Usuario());
                resenia.setProfesor(new Profesor());
                resenia.getUsuario().setIdUsuario(rs.getInt("fidUsuario")); 
                resenia.getUsuario().setNombre(rs.getString("unombre"));   
                resenia.getUsuario().setApellido(rs.getString("uapellido")); 
                resenia.getUsuario().setFoto(rs.getBytes("ufoto"));   
                resenia.getProfesor().setNombre(rs.getString("prnombre"));
                
                
                
                resenia.setCalificacion(rs.getInt("calificacion"));
                
                resenia.setContenido(rs.getString("contenido"));
                
                resenia.setBloqueado(rs.getBoolean("bloqueado"));
                
                resenia.setLikes(rs.getInt("likes"));
                
                resenia.setPrioridad(rs.getInt("prioridad"));
               
                resenia.setFechaRegistro(rs.getDate("fechaRegistro"));
                
                resenia.setActivo(true);
                
                resenia.setTipo(rs.getInt("tipo"));
                
                resenias.add(resenia);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resenias;
    }
    
    @Override
    public int eliminarReseniasProfesor(int idResenia) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_RESENIA_PROFESOR(?)}");
            cs.setInt("_idResenia", idResenia);
            resultado = cs.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }
}
