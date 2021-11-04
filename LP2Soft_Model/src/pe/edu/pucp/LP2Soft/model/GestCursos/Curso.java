/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestCursos;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import java.util.ArrayList;

public class Curso{

    
    private int idCurso;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String especialidad;
    private float creditos;
    private int nivel;
    private float creditosRequeridos;
    private int estado;
    private boolean activo;
    private boolean favorito;
    
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
            this.activo = true;
            this.profesores = new ArrayList<Profesor>();
            this.posts = new ArrayList<Post>();
            this.cursosRequeridos = new ArrayList<Curso>();
    }
    
    public Curso(){}

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public float getCreditosRequeridos() {
        return creditosRequeridos;
    }

    public void setCreditosRequeridos(float creditosRequeridos) {
        this.creditosRequeridos = creditosRequeridos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Curso> getCursosRequeridos() {
        return cursosRequeridos;
    }

    public void setCursosRequeridos(ArrayList<Curso> cursosRequeridos) {
        this.cursosRequeridos = cursosRequeridos;
    }

     
  

    
}
