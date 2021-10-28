/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;

public class NotificacionEvento extends Notificacion {
    /* Mostrar: Información del "eventoAgendado" */
    // tienes un vento programacdo para hoy: "eventoAgendado"
    private Evento eventoAgendado;

    public Evento getEventoAgendado() {
        return eventoAgendado;
    }

    public void setEventoAgendado(Evento eventoAgendado) {
        this.eventoAgendado = eventoAgendado;
    }
    
}
