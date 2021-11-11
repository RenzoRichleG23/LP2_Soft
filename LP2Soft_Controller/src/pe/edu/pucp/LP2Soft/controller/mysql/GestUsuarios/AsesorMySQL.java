/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class AsesorMySQL implements AsesorDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;
    
    @Override
    public int insertar(Asesor a, int fidUsuario, int fidCurso) {
        int resultado=-1;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_ASESOR(?,?,?,?,?)}");
            cs.registerOutParameter("_resultado", java.sql.Types.INTEGER);
            cs.setInt("_idUsuario", fidUsuario);
            cs.setDouble("_calificacion", a.getCalificacion());
            cs.setDouble("_precioXhora", a.getPrecioPorHora());
            cs.setInt("_fidCurso", fidCurso);
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
    public int modificar(Asesor a) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_ASESOR(?,?,?)}");
            cs.setInt("_idAsesor", a.getIdAsesor());
            cs.setFloat("_calificacion", a.getCalificacion());
            cs.setFloat("_precioPorHora",a.getPrecioPorHora());
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
            con = DBManager.getInstance().getConnection();
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
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ASESORES()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                float precioPorHora = rs.getFloat("precioPorHora");
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

    @Override
    public ArrayList<Usuario> listarXnombreYcurso(String nombre) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ASESORES(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCodigoPUCP(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setFoto(rs.getBytes("foto"));
                //Instancio y obtengo los datos del asesor y los seteo en el usuario
                usuario.setAsesor(new Asesor());
                usuario.getAsesor().setIdAsesor(rs.getInt("idAsesor"));
                usuario.getAsesor().setActivo(true);
                usuario.getAsesor().setCalificacion(rs.getFloat("calificacion"));
                usuario.getAsesor().setCantidadResenias(rs.getInt("cantidadResenias"));
                usuario.getAsesor().setSumatoriaResenias(rs.getInt("sumatoriaResenias"));
                usuarios.add(usuario);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return usuarios;
    }

    @Override
    public ArrayList<Curso> listarCursosAsesorados(int fidAsesor) {
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSOS_ASESOR(?)}");
            cs.setInt("_idAsesor", fidAsesor);
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
    public int insertarReseniaAsesor(Resenia re) {
        int resultado=-1;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_RESENIA_ASESOR(?,?,?,?,?,?)}");
            cs.registerOutParameter("_idResenia", java.sql.Types.INTEGER);
            cs.setInt("_fidUsuario", re.getUsuario().getIdUsuario());
            cs.setString("_descripcion", re.getContenido());
            cs.setInt("_prioridad", re.getPrioridad());
            cs.setInt("_fidAsesorReseniado", re.getUsuarioReseniado().getAsesor().getIdAsesor());
            cs.setInt("_calificacion", re.getCalificacion());
            cs.executeUpdate();
            resultado = cs.getInt("_idResenia");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    
}
