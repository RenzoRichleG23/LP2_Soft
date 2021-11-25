/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Notificacion;

public interface NotificacionDAO {
    int insertarNotificacion(int idUsuarioNotificado, int tipo, int subTipo, 
            int idUsuarioNotificador, int idCursoFavorito, int idEventoAgendado, int idPost);
    ArrayList<Notificacion> listarNotificaciones(int idUsuario);
    int eliminarSolicitudAmistad(int idUsuarioNotificado, int idUsuarioNotificador);
    int existeNotificaconEvento(int idUsuario, int idEvento);
}
