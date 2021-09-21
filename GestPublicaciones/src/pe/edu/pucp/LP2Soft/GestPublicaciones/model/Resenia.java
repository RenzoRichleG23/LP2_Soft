/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestPublicaciones.model;

public class Resenia extends Post{
    private int idResenia;
    private int calificacion;
    // private Usuario usuarioReseniado; ?????
    // Constructor
    public Resenia(int idResenia, int calificacion, int idPost,
            String comentarioPost, int likes, int prioridad) {
        super(idPost, comentarioPost, likes, prioridad);
        this.idResenia = idResenia;
        this.calificacion = calificacion;
    }
    // Getters
    public int getIdResenia() {
        return idResenia;
    }
    public int getCalificacion() {
        return calificacion;
    }
    // Setters
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
