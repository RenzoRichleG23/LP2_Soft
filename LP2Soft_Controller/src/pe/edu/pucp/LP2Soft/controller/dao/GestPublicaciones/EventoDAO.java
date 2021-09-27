/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;

public interface EventoDAO {
    int insertar(Evento evento);
    int modificar(Evento evento);
    int eliminar(int idEvento);
    ArrayList<Evento> listarTodos();
}
