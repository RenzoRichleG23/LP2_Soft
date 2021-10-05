/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ComentarioDAO;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;

public class ComentarioMySQL implements ComentarioDAO{
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;
    
    @Override
    public int insertar(Comentario comment) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_COMENTARIO(?,?,?,?,?)}");
            cs.registerOutParameter("_idComentario", java.sql.Types.INTEGER);
            cs.setInt("_fidPost", comment.getPost().getIdPost());  
            cs.setInt("_fidUsuario", comment.getUsuario().getCodigoPUCP());
            cs.setString("_coment", comment.getComentario());
            cs.setDate("_fechaRegistro", new java.sql.Date(comment.getFechaRegistro().getTime()));
            cs.executeUpdate();
            resultado = cs.getInt("_idComentario");
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Comentario comment) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MODIFICAR_COMENTARIO(?,?)}");
            cs.setInt("_idComentario", comment.getIdComentario());
            cs.setString("_coment", comment.getComentario());            
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
    public int eliminar(int idComentario) {
        int resultado=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_COMENTARIO(?)}");
            cs.setInt("_idComentario", idComentario);
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
    public ArrayList<Comentario> listarTodos(int idPost) {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        boolean resultados=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_COMENTARIOS(?)}");
            cs.setInt("_idPost", idPost);
            rs = cs.executeQuery();
            while(rs.next()) {
                int idComentario = rs.getInt("idComentario");
                String coment = rs.getString("coment");
                Date fechaRegistro = rs.getDate("fechaRegistro");

                Comentario comment = new Comentario();
                comment.setIdComentario(idComentario);
                comment.setComentario(coment);
                comment.setFechaRegistro(fechaRegistro);
                comentarios.add(comment);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        
        return comentarios;
    }
}
