/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.PostMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

@WebService(serviceName = "PublicacionesWS")
public class PublicacionesWS {
    private PostDAO daoPost;
    
    public PublicacionesWS(){
        daoPost = new PostMySQL();
    }
    
    @WebMethod(operationName = "insertarPost")
    public int insertarPost(@WebParam(name = "post") PostGenerico post) {
        int resultado = daoPost.insertar(post);
        return resultado;
    }
    
    @WebMethod(operationName = "listarPost")
    public ArrayList<PostGenerico> listarPost() {
        ArrayList<PostGenerico> posts = null;
        posts = daoPost.listarTodos();
        return posts;
    }
}
