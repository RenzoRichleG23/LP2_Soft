/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Resenia extends Post{

    /**
     * @param usuarioReseniado the usuarioReseniado to set
     */
    public void setUsuarioReseniado(Usuario usuarioReseniado) {
        this.usuarioReseniado = usuarioReseniado;
    }
    private int calificacion;
    private Usuario usuarioReseniado;
    // Constructor
    public Resenia(){}
    public Resenia(int calificacion, Usuario usuarioReseniado, String comentarioPost) {
        super(comentarioPost);
        this.usuarioReseniado = usuarioReseniado;
        this.calificacion = calificacion;
    }
    // Getters
    public int getCalificacion() {
        return calificacion;
    }
    public Usuario getUsuarioReseniado() {
        return usuarioReseniado;
    }
    
    // Setters
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
