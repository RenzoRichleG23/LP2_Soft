/**
 *
 * @author INFunables
 */

package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ComentarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.ComentarioMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

public class Principal_Comentario {
    public static void main(String[] args) {
        // SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try {
            // INSERTAR
            
            // Date fechaN = formato.parse("31-10-2021 ");
            Usuario user = new Usuario();
            user.setIdUsuario(20186019);
            PostGenerico post = new PostGenerico();
            post.setIdPost(18);
            
            Comentario comment = new Comentario();
            comment.setPost(post);
            comment.setUsuario(user);
            comment.setComentario("Genial Gracias!!!");
            
            
            ComentarioDAO daoComentario = new ComentarioMySQL();
            daoComentario.insertar(comment);
            
            //Comentario comment = new Comentario(user,"LP2 es un buen curso");
            //comment.setPost(post);
//            ComentarioDAO daoComentario = new ComentarioMySQL();
            //daoComentario.insertar(comment);
            
            //LISTAR COMENTARIOS
//            ArrayList<Comentario> comentarios = daoComentario.listarTodos(1);
//            comentarios.get(1).setComentario("CHUPETIN GAA");
//            daoComentario.modificar(comentarios.get(1));
            
//            daoComentario.eliminar(2);
            //MODIFICAR 
            //ComentarioDAO daoComentario = new ComentarioMySQL();
            //daoComentario.modificar(comment);
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}