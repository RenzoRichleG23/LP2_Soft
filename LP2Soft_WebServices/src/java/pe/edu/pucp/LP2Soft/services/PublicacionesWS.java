/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ComentarioDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.EventoDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.MaterialDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.ComentarioMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.EventoMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.PostMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Material;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

@WebService(serviceName = "PublicacionesWS")
public class PublicacionesWS {
    private PostDAO daoPost;
    private ComentarioDAO daoComentario;
    private EventoDAO daoEvento;
    private MaterialDAO daoMaterial;
    public PublicacionesWS(){
        daoPost = new PostMySQL();
        daoComentario = new ComentarioMySQL();
        daoEvento  =new EventoMySQL();
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
    
    @WebMethod(operationName = "aumentarLikes")
    public int aumentarLikes(@WebParam(name = "idPost") int idPost) {
        int resultado = daoPost.aumentarLike(idPost);
        return resultado;
    }
    
    @WebMethod(operationName = "disminuirLikes")
    public int disminuirLikes(@WebParam(name = "idPost") int idPost) {
        int resultado = daoPost.disminuirLike(idPost);
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarComentario")
    public int eliminarComentario(@WebParam(name = "comentario") Comentario comentario) {
        int resultado = daoComentario.eliminar(comentario);
        return resultado;
    }
    
    @WebMethod(operationName = "insertarEvento")
    public int insertarEvento(@WebParam(name = "evento") Evento evento) {
        int resultado = daoEvento.insertar(evento);
        return resultado;
    }
    
    @WebMethod(operationName = "listarMisEventos")
    public ArrayList<Evento> listarMisEventos(@WebParam(name = "idUsuario") int idUsuario) {
        ArrayList<Evento> eventos = null;
        eventos = daoEvento.listarMisEventos(idUsuario);
        return eventos;
    }
    
    @WebMethod(operationName = "insertar_Material")
    public int insertar_Material(@WebParam(name = "material") Material material) {
        int resultado = daoMaterial.insertar_Material(material);
        return resultado;
    }
    
    @WebMethod(operationName = "insertar_postXCurso")
    public int insertar_postXCurso(@WebParam(name = "post") PostGenerico post) {
        int resultado = daoPost.insertar(post);
        return resultado;
    }
}
