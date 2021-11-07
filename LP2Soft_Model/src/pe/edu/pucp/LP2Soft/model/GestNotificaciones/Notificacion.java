/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public abstract class Notificacion {
    private int idUsiarioNotificado;
    private Date fecha;
    private boolean leido;
    private int tipo; // 0Admin 1Amistad; 2Curso; 3Evento; 4Post

    public int getIdUsiarioNotificado() {
        return idUsiarioNotificado;
    }

    public void setIdUsiarioNotificado(int idUsiarioNotificado) {
        this.idUsiarioNotificado = idUsiarioNotificado;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
