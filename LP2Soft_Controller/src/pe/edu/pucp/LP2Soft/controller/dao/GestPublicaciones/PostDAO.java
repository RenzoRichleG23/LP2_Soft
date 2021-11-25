/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;

public interface PostDAO {
    int insertar(PostGenerico post);
    int modificar(PostGenerico post);
    int eliminar(PostGenerico post);
    ArrayList<PostGenerico> listarTodos();
    int aumentarLike(int idPost);
    int disminuirLike(int idPost);
    int insertar_postXCurso(PostGenerico post);
    ArrayList<PostGenerico> listarXcurso(int idCurso);
    ArrayList<PostGenerico> listarMisPublicaciones(int idUsuario,int idCurso,String fechaI,String fechaF,int flag);
}
