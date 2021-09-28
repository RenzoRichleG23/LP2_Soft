/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;
import java.sql.Connection; // No confundir
import java.sql.ResultSet; // No confundir
import java.sql.PreparedStatement; // No confundir
import java.sql.Statement; // No confundir
import java.sql.DriverManager;  // No confundir
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
            // Verificar si nombre, correo y codigo ya están: procedure
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call usuarioSignIn(?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_resultado", java.sql.Types.INTEGER);
            cs.setInt("_idUsuario", u.getCodigoPUCP()); // seteamos los valores a enviar
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
            String instruccion = "UPDATE usuario SET nombre = ?, correo = ?,"
                    + "contrasenia = ?, fechaNacimiento=?, descripcion=?, foto=? WHERE idUsuario=?";
            ps = con.prepareStatement(instruccion);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContrasenia());
            ps.setDate(4, new java.sql.Date(u.getFechaNacimiento().getTime()));
            ps.setString(5, u.getDescripcion());
            ps.setBytes(6, u.getFoto());
            ps.setInt(7, u.getCodigoPUCP());
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
    public int eliminar(int codigoPUCP) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE usuario SET activo=0 WHERE idUsuario=?";
            ps = con.prepareStatement(instruccion);
            ps.setInt(1, codigoPUCP);
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
    public ArrayList<Usuario> listarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            st = con.createStatement();
            String instruccion = "SELECT * FROM usuario WHERE activo=1";
            rs = st.executeQuery(instruccion);
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
            try {rs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
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
            st = con.createStatement();
            String instruccion = "SELECT * FROM usuario WHERE idUsuario = " + codigoPUCP + " AND activo=1";
            rs = st.executeQuery(instruccion);
            rs.next();
            
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
                usuario.setActivo(true);
                if(rs.getInt("esAdmin")==1) usuario.setEsAdmin(true);
                if(rs.getInt("esAsesor")==1) usuario.setEsAsesor(true);
                
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {st.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return usuario;
    }

}
