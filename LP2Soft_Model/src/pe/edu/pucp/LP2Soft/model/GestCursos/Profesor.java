/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestCursos;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;

public class Profesor{
    private int idProfesor;
    private String nombre;
    private String correo;
    private String descripcion;
    private float calificacion;
    private byte[] foto; // Cómo es esto?
    private boolean activo;
    
    private ArrayList<Curso>cursos;
    private ArrayList<Resenia>resenias;

    // Constructor
    public Profesor(int idProfesor, String nombre, String correo, String descripcion){
        this.cursos = new ArrayList<>();
        this.resenias = new ArrayList<>();
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.calificacion = 0;
        this.correo = correo;
        this.descripcion = descripcion;
        this.activo = true;
    }
    public Profesor(){}
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
    public ArrayList<Resenia> getResenias() {
        return resenias;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void setidProfesor(int idProfesor){
        this.idProfesor = idProfesor;
    }
    
    public void setCalificacion(float calificacion){
        this.calificacion = calificacion;
    }
}