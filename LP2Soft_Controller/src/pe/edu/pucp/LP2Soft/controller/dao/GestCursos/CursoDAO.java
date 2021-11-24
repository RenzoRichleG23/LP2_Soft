/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestCursos;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

public interface CursoDAO {
    int insertar(Curso curso);
    int modificar(Curso curso);
    int eliminar(String curso);
    ArrayList<Curso> listarCursos(int idUsuario);
    Curso MostrarCurso(int idCurso);
    ArrayList<Curso> listaXciclo(int nivel);
    int actualizarCursoxUsuario(int fidUsuario, int fidCurso, int estado, int favorito);
    ArrayList<Curso> listarCursosPostular();
}
