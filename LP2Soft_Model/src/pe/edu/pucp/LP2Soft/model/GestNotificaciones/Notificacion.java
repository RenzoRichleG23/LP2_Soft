/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Notificacion {
    private Usuario usiarioNotificado;
    private Date fecha;
    private boolean leido;
    private int tipo;
    
    public Usuario getUsiarioNotificado() {
        return usiarioNotificado;
    }

    public void setUsiarioNotificado(Usuario usiarioNotificado) {
        this.usiarioNotificado = usiarioNotificado;
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
