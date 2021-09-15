/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestPublicaciones.model;
import java.util.ArrayList;
import java.util.Date;

public class Post {
    private int idPost;
    private String comentarioPost;
    private int likes;
    private int prioridad;
    private Date fechaRegistro;
    private ArrayList<Comentario> comentarios;
    // Constructor   
    public Post(int idPost, String comentarioPost, int likes, int prioridad){
        this.idPost = idPost;
        this.comentarioPost = comentarioPost;
        this.likes = likes;
        this.prioridad = prioridad;
        this.comentarios = new ArrayList<Comentario>();
        this.fechaRegistro = new Date();
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
