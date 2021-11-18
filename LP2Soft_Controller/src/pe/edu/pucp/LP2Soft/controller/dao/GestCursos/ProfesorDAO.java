/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestCursos;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;

public interface ProfesorDAO {
    int insertar(Profesor profesor);
    int modificar(Profesor profesor);
    int eliminar(int profesor);
    ArrayList<Profesor>listarProfesorNombre(String nombre);
    Profesor mostrarProfesor(int idProfesor);
    ArrayList<Curso>listarCursoProfesor(int  idProfesor);
    ArrayList<Profesor>listarProfesorXCurso(int idCurso);
    int insertarReseniaProfesor(Resenia re);
    ArrayList<Resenia> listarReseniasProfesor(int fidProfesor);
    int eliminarReseniasProfesor(int idResenia);
}
