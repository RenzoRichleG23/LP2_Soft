/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestCursos;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;

public interface ProfesorDAO {
    int insertar(Profesor profesor);
    int modificar(Profesor profesor);
    int eliminar(int profesor);
    ArrayList<Profesor>listarProfesorNombre(String nombre);
    Profesor mostrarProfesor(int idProfesor);
    ArrayList<Curso>listarCursoProfesor(int  idProfesor);
}
