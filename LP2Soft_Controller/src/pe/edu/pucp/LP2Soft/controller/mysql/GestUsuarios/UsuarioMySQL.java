/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement; 
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;

public class UsuarioMySQL implements UsuarioDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;
    
    @Override
    public int insertar(Usuario u) {
        int resultado=-1;
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
//            Date fecha = formato.parse("");
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_USUARIO(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_resultado", java.sql.Types.INTEGER);
            cs.setString("_codigo", u.getCodigoPUCP());
            cs.setString("_nombre", u.getNombre());
            cs.setString("_apellido", u.getApellido());
            cs.setString("_correo", u.getCorreo());
            cs.setString("_especialidad", u.getEspecialidad());
            cs.setString("_contrasenia", u.getContrasenia());
//            cs.setDate("_fechaNacimiento", new java.sql.Date(u.getFechaNacimiento().getTime())); 
            cs.executeUpdate();
            resultado = cs.getInt("_resultado");
            // sino sale -10 o -20, fue un registro exitoso y el resultado contiene el id
//            switch (resultado) {
//                case -10: System.out.println("Este código ya se encuentra registrado!"); break;
//                case -20: System.out.println("Este correo ya se encuentra registrado!"); break;
//                default: break;
//            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Usuario u) {
        int resultado=0;
        try {
            con = con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_USUARIO(?,?,?,?,?,?,?)}");
//            cs.setInt("_idUsuario", u.getCodigoPUCP());
            cs.setString("_nombre", u.getNombre());
            cs.setString("_correo", u.getCorreo());
            cs.setString("_contrasenia", u.getContrasenia());
            cs.setString("_descripcion", u.getDescripcion());
            cs.setDate("_fechaNacimiento", new java.sql.Date(u.getFechaNacimiento().getTime())); 
            cs.setBytes("_foto", u.getFoto());
            
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
    public int eliminar(int codigoPUCP) {
        int resultado=0;
        try {
            con = con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_USUARIO(?)}");
            cs.setInt("_idUsuario", codigoPUCP);
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
    public ArrayList<Usuario> listarNombreCodigo(String nombreCodigo) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            con = con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_USUARIOS_NOMBRECODIGO(?)}");
            cs.setString("_nombreCodigo", nombreCodigo);
            rs = cs.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCodigoPUCP(rs.getString("codigo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setFoto(rs.getBytes("foto"));
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
    public Usuario mostrar(String correoCodigo, int isCode) {
        Usuario usuario = null;
        try {
            con = con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MOSTRAR_USUARIO(?,?)}");
            cs.setString("_correoCodigo", correoCodigo);
            cs.setInt("_isCode", isCode);
            rs = cs.executeQuery();
            if(rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCodigoPUCP(rs.getString("codigo"));
                usuario.setEspecialidad(rs.getString("especialidad"));
                usuario.setContrasenia(rs.getString("contrasenia"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                usuario.setDescripcion(rs.getString("descripcion"));
                usuario.setFoto(rs.getBytes("foto"));
                usuario.setFoto(rs.getBytes("portada"));
                if(rs.getInt("esAdmin")==1) usuario.setEsAdmin(true);
                if(rs.getInt("esAsesor")==1) usuario.setEsAsesor(true);
            }else System.out.println("Usuario no encontrado!");
            
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return usuario;
    }

}
