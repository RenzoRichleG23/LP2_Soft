/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestCursos;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

public interface CursoDAO {
    int insertar(Curso curso);
    int modificar(Curso curso);
    int eliminar(int curso);
    ArrayList<Curso> listarTodos();
}
