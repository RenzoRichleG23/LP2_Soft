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
        this.comentarios = new ArrayList<>();
        this.fechaRegistro = new Date();
        this.activo = true;
        this.bloqueado = false;
    }
    
    public Post(String comentarioPost,int prioridad){
        this.comentarioPost = comentarioPost;
        this.likes = 0;
        this.prioridad = prioridad;
        this.comentarios = new ArrayList<>();
        this.fechaRegistro = new Date();
        this.activo = true;
        this.bloqueado = false;
    }
    
    public Post(){}
    
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
    public void setFechaRegistro(Date fechaRegistro){
        this.fechaRegistro=fechaRegistro;
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

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
