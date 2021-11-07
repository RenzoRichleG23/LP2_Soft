/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.MensajeDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.NotificacionDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestNotificaciones.MensajeMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestNotificaciones.NotificacionMySQL;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Mensaje;

@WebService(serviceName = "NotificacionesWS")
public class NotificacionesWS {
    private MensajeDAO daoMensaje;
    private NotificacionDAO daoNotificacion;
    
    public NotificacionesWS() {
        daoMensaje = new MensajeMySQL();
        daoNotificacion = new NotificacionMySQL();
    }
    @WebMethod(operationName = "enviarMensaje")
    public int enviarMensaje(@WebParam(name = "idUsuario1") int idUsuario1,
            @WebParam(name = "idUsuario2") int idUsuario2,
            @WebParam(name = "contenido") String contenido) {
        int resultado = daoMensaje.enviarMensaje(idUsuario1, idUsuario2, contenido);
        return resultado;
    }
    
    @WebMethod(operationName = "listarMensajesXAmigo")
    public ArrayList<Mensaje> listarMensajesXAmigo(@WebParam(name = "idUsuario1") int idUsuario1,
            @WebParam(name = "idUsuario2") int idUsuario2) {
        ArrayList<Mensaje> mensajes = null;
        mensajes = daoMensaje.listarMensajesXAmigo(idUsuario1, idUsuario2);
        return mensajes;
    }
    
    @WebMethod(operationName = "insertarNotificacionAdmin")
    public int insertarNotificacionAdmin(@WebParam(name = "idUsuario1") int idUsuario) {
        int resultado = daoNotificacion.insertarNotificacionAdmin(idUsuario);
        return resultado;
    }
}
