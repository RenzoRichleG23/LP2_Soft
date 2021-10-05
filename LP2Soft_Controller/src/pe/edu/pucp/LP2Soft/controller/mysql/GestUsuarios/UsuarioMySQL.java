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
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_USUARIO(?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_resultado", java.sql.Types.INTEGER);
            cs.setInt("_idUsuario", u.getCodigoPUCP());
            cs.setString("_nombre", u.getNombre());
            cs.setString("_correo", u.getCorreo());
            cs.setString("_especialidad", u.getEspecialidad());
            cs.setString("_contrasenia", u.getContrasenia());
            cs.setString("_descripcion", u.getDescripcion());
            cs.setDate("_fechaNacimiento", new java.sql.Date(u.getFechaNacimiento().getTime())); 
            cs.setBytes("_foto", u.getFoto());
            cs.executeUpdate();
            resultado = cs.getInt("_resultado");
            switch (resultado) {
                case 5: System.out.println("Registro exitoso!"); break;
                case 3: System.out.println("El nombre ya existe"); break;
                case 2: System.out.println("El correo ya existe"); break;
                case 1: System.out.println("El codigoPUCP ya existe"); break;
                default: break;
            }
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MODIFICAR_USUARIO(?,?,?,?,?,?,?)}");
            cs.setInt("_idUsuario", u.getCodigoPUCP());
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
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
    public ArrayList<Usuario> listarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        boolean resultados=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_USUARIOS()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                int codigoPUCP = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String especialidad = rs.getString("especialidad");
                String contrasenia = rs.getString("contrasenia");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String descripcion = rs.getString("descripcion");

                Usuario usuario = new Usuario(codigoPUCP, nombre, correo, especialidad, 
                        contrasenia, fechaNacimiento, descripcion);
                usuario.setActivo(true);
                if(rs.getInt("esAdmin")==1) usuario.setEsAdmin(true);
                if(rs.getInt("esAsesor")==1) usuario.setEsAsesor(true);
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
    public Usuario mostrar(int codigoPUCP, String password) {
        Usuario usuario = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MOSTRAR_USUARIO(?)}");
            cs.setInt("_idUsuario", codigoPUCP);
            rs = cs.executeQuery();
            if(rs.next()) {
                String contrasenia = rs.getString("contrasenia");
                if(contrasenia.equals(password)) {
                    String nombre = rs.getString("nombre");
                    String correo = rs.getString("correo");
                    String especialidad = rs.getString("especialidad");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    String descripcion = rs.getString("descripcion");
                    byte[] foto = rs.getBytes("foto");
                    usuario = new Usuario(codigoPUCP, nombre, correo, especialidad, 
                            contrasenia, fechaNacimiento, descripcion);
                    usuario.setFoto(foto);
                    usuario.setActivo(true);
                    if(rs.getInt("esAdmin")==1) usuario.setEsAdmin(true);
                    if(rs.getInt("esAsesor")==1) usuario.setEsAsesor(true);
                    
                } else System.out.println("Usuario y contrasenia no coinciden!");
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
