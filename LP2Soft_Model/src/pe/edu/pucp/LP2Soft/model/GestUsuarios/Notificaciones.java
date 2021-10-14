/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.LP2Soft.model.GestUsuarios;

import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;

/**
 * @author NAVARRO CIEZA, OSCAR DANIEL - 20186008
 * 
 */
public class Notificaciones {
    // alguien le dio like a mi publicación
    // alguien comentó mi publicacion
    // alguien subió material de un curso favorito //
    // mandaron solicitud de amistad
    // aceptaron mi solicitud de amistad
    // un evento está cerca
    private Usuario usiarioNotificado;
    private Usuario usuarioNotificador;
    private Post postRelacionado;
    private Curso curso;
    private Date fecha;
    private Evento evento;
}
