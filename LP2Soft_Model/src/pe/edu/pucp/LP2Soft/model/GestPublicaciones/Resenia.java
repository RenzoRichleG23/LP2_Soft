/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Resenia extends Post{

    
    private int calificacion;
    private Usuario usuarioReseniado;
    private Profesor profesor;
    // Constructor
    public Resenia(){}
    public Resenia(Usuario usuario,int calificacion, Usuario usuarioReseniado, String comentarioPost, Profesor profesor) {
        super(comentarioPost, usuario);
        super.setTipo(4);
        super.setBloqueado(true);
        this.usuarioReseniado = usuarioReseniado;
        this.calificacion = calificacion;
        this.profesor = profesor;
  
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
    /*  
     * @param usuarioReseniado the usuarioReseniado to set
     */
    public void setUsuarioReseniado(Usuario usuarioReseniado) {
        this.usuarioReseniado = usuarioReseniado;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
