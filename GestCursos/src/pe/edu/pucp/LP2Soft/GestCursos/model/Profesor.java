/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestCursos.model;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.GestPublicaciones.model.Comentario;
import pe.edu.pucp.LP2Soft.GestPublicaciones.model.Resenia;

public class Profesor{
    private int idProfesor;
    private String nombre;
    private float calificacion;
    private String correo;
    private byte[] foto; // Cómo es esto?
    private String descripcion;
    private ArrayList<Curso>cursos;
    private ArrayList<Comentario>comentarios;
    private ArrayList<Resenia>resenias;

    // Constructor
    public Profesor(int idProfesor, String nombre, float calificacion, String correo, String descripcion){
        this.cursos = new ArrayList<Curso>();
        this.comentarios = new ArrayList<Comentario>();
        this.resenias = new ArrayList<Resenia>();
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.correo = correo;
        this.descripcion = descripcion;
        // Falta lo de la foto
    }
    // Getters
    public int getIdProfesor() {
        return idProfesor;
    }
    public String getNombre() {
        return nombre;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public String getCorreo() {
        return correo;
    }
    public byte[] getFoto() {
        return foto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    public ArrayList<Resenia> getResenias() {
        return resenias;
    }
}