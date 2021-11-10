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
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Notificacion;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.UltimoMensaje;

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
    
    @WebMethod(operationName = "insertarNotificacion")
    public int insertarNotificacion(@WebParam(name = "idUsuarioNotificado") int idUsuarioNotificado,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "subTipo") int subTipo,
            @WebParam(name = "idUsuarioNotificador") int idUsuarioNotificador,
            @WebParam(name = "idCursoFavorito") int idCursoFavorito,
            @WebParam(name = "idEventoAgendado") int idEventoAgendado,
            @WebParam(name = "idPost") int idPost) {
        int resultado = daoNotificacion.insertarNotificacion(idUsuarioNotificado,
                tipo, subTipo, idUsuarioNotificador, idCursoFavorito, idEventoAgendado, idPost);
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarSolicitudAmistad")
    public int eliminarSolicitudAmistad(@WebParam(name = "idUsuarioNotificado") int idUsuarioNotificado,
            @WebParam(name = "idUsuarioNotificador") int idUsuarioNotificador) {
        int resultado = daoNotificacion.eliminarSolicitudAmistad(idUsuarioNotificado, idUsuarioNotificador);
        return resultado;
    }

    @WebMethod(operationName = "listarNotificaciones")
    public ArrayList<Notificacion> listarNotificaciones(@WebParam(name = "idUsuario") int idUsuario) {
        ArrayList<Notificacion> notificaciones = null;
        notificaciones = daoNotificacion.listarNotificaciones(idUsuario);
        return notificaciones;
    }


    @WebMethod(operationName = "listarMensajesUltimos")
    public ArrayList<UltimoMensaje> listarMensajesUltimos(@WebParam(name = "idUsuario") int idUsuario) {
        ArrayList<UltimoMensaje> mensajes = null;
        mensajes = daoMensaje.listarUltimosMensajes(idUsuario);
        return mensajes;
    }
}
