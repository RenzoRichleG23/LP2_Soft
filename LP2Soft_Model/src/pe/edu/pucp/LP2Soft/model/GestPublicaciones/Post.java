/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Post {
    private int idPost;
    private int likes;
    private int prioridad;
    private Date fechaRegistro;
    private String comentarioPost;
    private boolean bloqueado;
    private boolean activo;
    
    private Usuario usuario;
    private ArrayList<Comentario> comentarios;
    // Constructor   
    public Post(String comentarioPost){
        this.comentarioPost = comentarioPost;
        this.likes = 0;
        this.prioridad = 0;
        this.comentarios = new ArrayList<>();
        this.fechaRegistro = new Date();
        this.activo = true;
    }  
    // Getters
    public String getComentarioPost() {
        return comentarioPost;
    }
    public int getLikes() {
        return likes;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public int getIdPost() {
        return idPost;
    }
    // Setters
    public void setComentarioPost(String comentarioPost) {
        this.comentarioPost = comentarioPost;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
}
