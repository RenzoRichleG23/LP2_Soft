/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;


public interface ReseniaDAO {
    int insertar(Resenia resenia);
    int meodificar(Resenia resenia);
    int eliminar(Resenia resenia);
    ArrayList<Resenia> listarTodos();
}