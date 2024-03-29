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
    ResultSet rs;
    CallableStatement cs;
    Connection con2;
    ResultSet rs2;
    CallableStatement cs2;
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
    public ArrayList<Curso> listarCursos(int idUsuario) {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSOS(?)}");
            cs.setInt("_idUsuario",idUsuario);
            rs = cs.executeQuery();
            while(rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigo(rs.getString("CodigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setNivel(rs.getInt("nivel"));
                curso.setCreditos(rs.getFloat("creditos"));
                curso.setEstado(rs.getInt("estado"));
                curso.setCreditosRequeridos(rs.getFloat("creditosRequeridos"));
                if(rs.getInt("favorito") == 0)
                    curso.setFavorito(false);
                else curso.setFavorito(true);
                
                cs2 = con.prepareCall("{call MOSTRAR_REQUISITOSCURSOSXCURSOS(?)}");
                cs2.setInt("_idCurso",curso.getIdCurso());
                rs2 = cs2.executeQuery();
                ArrayList<Curso> cursosReq = new ArrayList<>();
                while(rs2.next()) {
                    Curso curso2 = new Curso();
                    curso2.setIdCurso(rs2.getInt("fidCurso2"));
                    cursosReq.add(curso2);
                }
                curso.setCursosRequeridos(cursosReq);
                cursos.add(curso);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close(); cs2.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return cursos;
    }

    @Override
    public Curso MostrarCurso(int idCurso) {
        Curso curso = new Curso();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MOSTRAR_CURSOS(?)}");
            cs.setInt("_idCurso",idCurso);
            rs = cs.executeQuery();
            while(rs.next()) {  
                curso.setIdCurso(idCurso);
                curso.setCodigo(rs.getString("CodigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                curso.setNivel(rs.getInt("nivel"));
                //System.out.println(curso.getCodigo());
                curso.setCreditos(rs.getFloat("creditos"));
                curso.setEspecialidad(rs.getString("especialidad"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setCreditosRequeridos(rs.getFloat("creditosRequeridos"));
                curso.setCantPc(rs.getInt("cantPc"));
                curso.setCantEx(rs.getInt("cantEx"));
                curso.setCantTA(rs.getInt("cantTA"));
                curso.setCantLab(rs.getInt("cantLab"));
               } 
            cs = con.prepareCall("{call MOSTRAR_REQUISITOSCURSOSXCURSOS(?)}");
            cs.setInt("_idCurso",idCurso);
            rs = cs.executeQuery();
            ArrayList<Curso> cursos = new ArrayList<>();
            while(rs.next()) {
                Curso curso2 = new Curso();
                
                curso2.setIdCurso(rs.getInt("fidCurso2"));
                curso2.setNombre(rs.getString("nombre"));
                //System.out.println(curso2.getNombre());
                cursos.add(curso2);
            } 
            curso.setCursosRequeridos(cursos);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return curso;
    }

    @Override
    public ArrayList<Curso> listaXciclo(int nivel) {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MOSTRAR_CURSOS_NIVEL(?)}");
            cs.setInt("_nivel",nivel);
            rs = cs.executeQuery();
            while(rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigo(rs.getString("CodigoCurso"));
                System.out.println(curso.getCodigo());
                curso.setNombre(rs.getString("nombre"));
                curso.setNivel(rs.getInt("nivel"));
                curso.setCreditos(rs.getFloat("creditos"));
                //curso.setEstado(rs.getInt("estado"));
//                if(rs.getInt("favorito") == 0)
//                    curso.setFavorito(false);
//                else curso.setFavorito(true);
//                
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
    public int actualizarCursoxUsuario(int fidUsuario, int fidCurso, int estado, int favorito) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CURSOXUSUARIO(?,?,?,?)}");
            cs.setInt("_fidUsuario", fidUsuario);
            cs.setInt("_fidCurso", fidCurso);
            cs.setInt("_estado", estado);
            cs.setInt("_favorito", favorito);
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
    public ArrayList<Curso> listarCursosPostular() {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSOS_POSTULAR()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCodigo(rs.getString("CodigoCurso"));
                curso.setNombre(rs.getString("nombre"));
                cursos.add(curso);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close(); cs2.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return cursos;
    }
}
