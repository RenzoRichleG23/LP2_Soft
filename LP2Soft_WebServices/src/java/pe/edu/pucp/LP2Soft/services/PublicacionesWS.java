/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ComentarioDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.ComentarioMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.PostMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

@WebService(serviceName = "PublicacionesWS")
public class PublicacionesWS {
    private PostDAO daoPost;
    private ComentarioDAO daoComentario;
    
    public PublicacionesWS(){
        daoPost = new PostMySQL();
        daoComentario = new ComentarioMySQL();
    }
    
    @WebMethod(operationName = "insertarPost")
    public int insertarPost(@WebParam(name = "post") PostGenerico post) {
        int resultado = daoPost.insertar(post);
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPost")
    public int modificarPost(@WebParam(name = "post") PostGenerico post) {
        int resultado = daoPost.modificar(post);
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPost")
    public int eliminarPost(@WebParam(name = "post") PostGenerico post) {
        int resultado = daoPost.eliminar(post);
        return resultado;
    }
    
    @WebMethod(operationName = "listarPost")
    public ArrayList<PostGenerico> listarPost() {
        ArrayList<PostGenerico> posts = null;
        posts = daoPost.listarTodos();
        return posts;
    }
    
    @WebMethod(operationName = "insertarComentario")
    public int insertarComentario(@WebParam(name = "comentario") Comentario comentario) {
        int resultado = daoComentario.insertar(comentario);
        return resultado;
    }
    
    @WebMethod(operationName = "listarComentarios")
    public ArrayList<Comentario> listarComentarios(@WebParam(name = "idPost") int idPost) {
        ArrayList<Comentario> comentarios = null;
        comentarios = daoComentario.listarTodos(idPost);
        return comentarios;
    }
}
