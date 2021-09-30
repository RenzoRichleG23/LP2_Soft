/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;

public interface PostDAO {
    int insertar(Post post);
    int meodificar(Post post);
    int eliminar(Post post);
    ArrayList<Post> listarTodos();
}
