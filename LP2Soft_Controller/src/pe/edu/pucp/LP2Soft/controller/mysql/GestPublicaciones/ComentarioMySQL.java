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
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

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
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_COMENTARIO(?,?,?,?,?)}");
            cs.registerOutParameter("_idComentario", java.sql.Types.INTEGER);
            cs.setInt("_fidPost", comment.getPost().getIdPost());  
            cs.setInt("_fidUsuario", comment.getUsuario().getIdUsuario());
            cs.setString("_coment", comment.getComentario());
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dt = new Date();
            comment.setFechaRegistro(formato.parse(formato.format(dt)));
            
            cs.setDate("_fechaRegistro", new java.sql.Date(comment.getFechaRegistro().getTime()));
            cs.executeUpdate();
            comment.setIdComentario(cs.getInt("_idComentario"));
            resultado = comment.getIdComentario();
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
            con = DBManager.getInstance().getConnection();
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
    public int eliminar(Comentario comentario) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_COMENTARIO(?,?)}");
            cs.setInt("_idComentario", comentario.getIdComentario());
            cs.setInt("_idPost", comentario.getPost().getIdPost());
            cs.executeUpdate();
            resultado=1;
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
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_COMENTARIOS(?)}");
            cs.setInt("_idPost", idPost);
            rs = cs.executeQuery();
            while(rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("idComentario"));
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("fidUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                //usuario.setFoto(rs.getBytes("foto"));
                Post post=new PostGenerico();
                post.setIdPost(rs.getInt("fidPost"));
                comentario.setPost(post);
                comentario.setUsuario(usuario);
                comentario.setComentario(rs.getString("coment"));
                
                comentarios.add(comentario);
            }
            resultado=1;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        if(resultado==1)
            return comentarios;
        else
            return null;
    }
}
