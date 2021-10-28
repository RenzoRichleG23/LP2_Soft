/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Mensaje {
    private Usuario remitente;
    private Usuario destinatario;
    private String contenido;
    private Date fechayHora;
    private boolean leido;

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(Date fechayHora) {
        this.fechayHora = fechayHora;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
    
}
