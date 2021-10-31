/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

public interface PostDAO {
    int insertar(PostGenerico post);
    // int meodificar(Post post);
    // int eliminar(Post post);
    ArrayList<PostGenerico> listarTodos();
}
