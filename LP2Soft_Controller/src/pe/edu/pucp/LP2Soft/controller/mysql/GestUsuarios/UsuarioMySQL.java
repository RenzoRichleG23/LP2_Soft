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
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;

public class UsuarioMySQL implements UsuarioDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    
    @Override
    public int insertar(Usuario u) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "INSERT INTO usuario(codigoPUCP, nombre, correo, "
                    + "especialidad, contrasenia, descripcion, fechaNacimiento, foto,"
                    + "creditosTotales, esAsesor, esAdmin, activo, fid_asesor) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,0,0,1,0)";
            ps = con.prepareStatement(instruccion);
            ps.setInt(1, u.getCodigoPUCP());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getEspecialidad());
            ps.setString(5, u.getContrasenia());
            ps.setString(6, u.getDescripcion());
            ps.setDate(7, new java.sql.Date(u.getFechaNacimiento().getTime()));
            ps.setBytes(8, u.getFoto());
            ps.setFloat(9, u.getCreditosTotales());
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
    public int modificar(Usuario u) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            String instruccion = "UPDATE usuario SET nombre = ?, correo = ?,"
                    + "contrasenia = ?, fechaNacimiento=?, descripcion=?, foto=? WHERE codigoPUCP=?";
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
            String instruccion = "UPDATE activo=0 WHERE codigoPUCP=?";
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
            String instruccion = "SELECT * FROM area WHERE activo=1";
            rs = st.executeQuery(instruccion);
            while(rs.next()) {
                int codigoPUCP = rs.getInt("codigoPUCP");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String especialidad = rs.getString("especialidad");
                String contrasenia = rs.getString("contrasenia");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String descripcion = rs.getString("descripcion");

                Usuario usuario = new Usuario(codigoPUCP, nombre, correo, especialidad, 
                        contrasenia, fechaNacimiento, descripcion);
                usuario.setActivo(true);
                usuarios.add(usuario);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {st.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return usuarios;
    }

}
