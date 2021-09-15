/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestPublicaciones.model;
import java.util.Date;

public class Comentario {
    private int idComentario;
    private String comentario;
    private Date fechaRegistro;
    private String nombreUsuario;
    // Constructor
    public Comentario(int idComentario, String nombreUsuario, String comentario) {
        this.idComentario = idComentario;
        this.nombreUsuario = nombreUsuario;
        this.comentario = comentario;
        this.fechaRegistro = new Date();
    }
    // Getters
    public int getIdComentario() {
        return idComentario;
    }
    public String getComentario() {
        return comentario;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    //Setters
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
