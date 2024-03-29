/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Comentario {
    private int idComentario;
    private String comentario;
    private Date fechaRegistro;
    private boolean activo;
    
    private Usuario usuario;
    private Post post;
    // Constructor
    public Comentario() {}
    public Comentario(Usuario usuario, String comentario) {
        this.comentario = comentario;
        this.fechaRegistro = new Date();
        this.usuario = usuario;
        this.activo = true;
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
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Post getPost() {
        return post;
    }
    //Setters
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}