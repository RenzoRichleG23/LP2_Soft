/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestCursos;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import java.util.ArrayList;

public class Curso{
    private String codigo;
    private String nombre;
    private float creditos;
    private String especialidad;
    private int nivel;
    private String descripcion;
    private float creditosRequeridos;
    private int estado;
    
    private ArrayList<Profesor>profesores;
    private ArrayList<Post>posts;
    private ArrayList<Curso>cursosRequeridos; // No queremos crear nuevas instancias, solamente apuntar a los que ya se habían creado
    // Constructor
    public Curso(String codigo, String nombre, float creditos, 
            String especialidad, int nivel, String descripcion, float creditosRequeridos, int estado){
            this.codigo = codigo;
            this.nombre = nombre;
            this.creditos = creditos;
            this.especialidad = especialidad;
            this.nivel = nivel;
            this.descripcion = descripcion;
            this.creditosRequeridos = creditosRequeridos;
            this.estado = estado;
            this.profesores = new ArrayList<Profesor>();
            this.posts = new ArrayList<Post>();
            this.cursosRequeridos = new ArrayList<Curso>();
    }
    // Getters
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    public ArrayList<Curso> getCursosRequeridos() {
        return cursosRequeridos;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public float getCreditos() {
        return creditos;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public int getNivel() {
        return nivel;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public float getCreditosRequeridos() {
        return creditosRequeridos;
    }
    public int getEstado() {
        return estado;
    }
}