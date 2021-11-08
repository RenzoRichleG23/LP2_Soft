/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Mensaje;

public interface MensajeDAO {
    int enviarMensaje(int idUsuario1, int idUsuario2, String contenido);
    ArrayList<Mensaje>listarMensajesXAmigo(int idUsuario1, int idUsuario2);
}
