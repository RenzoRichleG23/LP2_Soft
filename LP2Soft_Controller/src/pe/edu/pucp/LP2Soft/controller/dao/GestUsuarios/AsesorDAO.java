/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;

public interface AsesorDAO {
    int insertar(Asesor a, int fidUsuario, int fidCurso);
    int modificar(Asesor a);
    int eliminar(int idAsesor);
    ArrayList<Asesor> listarTodos();
}
