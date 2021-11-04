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
    private byte[] foto; //
    private byte[] portada; //
    private boolean activo;
    
    private ArrayList<Curso>cursos;
    private ArrayList<Resenia>resenias;

    // Constructor
    public Profesor(int idProfesor, String nombre, String correo, String descripcion){
        //this.cursos = new ArrayList<>();
        //this.resenias = new ArrayList<>();
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

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(ArrayList<Resenia> resenias) {
        this.resenias = resenias;
    }
   
}