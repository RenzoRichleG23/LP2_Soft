
/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;

public interface ComentarioDAO {
    int insertar(Comentario comment);
    int modificar(Comentario comment);
    int eliminar(int idComentario);
    ArrayList<Comentario> listarTodos(int idPost);
}
