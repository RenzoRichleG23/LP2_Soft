/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Resenia extends Post{
    private int calificacion;
    private Usuario usuarioReseniado;
    // Constructor
    public Resenia(int calificacion, Usuario usuario, String comentarioPost, int likes, int prioridad) {
        super(comentarioPost);
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
