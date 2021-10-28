/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class NotificacionAmistad extends Notificacion {
    /* Mostrar: Perfil de "amigo" */
    // "amigo" ha aceptado tu solicitud de amistad: 1
    // "amigo" te ha enviado una solicitud de amistad: 0
    private Usuario amigo;
    private boolean esAmigo; // true: 1 / false: 0

    public Usuario getAmigo() {
        return amigo;
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }

    public boolean isEsAmigo() {
        return esAmigo;
    }

    public void setEsAmigo(boolean esAmigo) {
        this.esAmigo = esAmigo;
    }
    
}
