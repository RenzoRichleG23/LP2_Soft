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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    /**
     * @return the idCurso
     */
    public int getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @param creditosRequeridos the creditosRequeridos to set
     */
    public void setCreditosRequeridos(float creditosRequeridos) {
        this.creditosRequeridos = creditosRequeridos;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the favorito
     */
    public boolean isFavorito() {
        return favorito;
    }

    /**
     * @param favorito the favorito to set
     */
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    /**
     * @param profesores the profesores to set
     */
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    /**
     * @param cursosRequeridos the cursosRequeridos to set
     */
    public void setCursosRequeridos(ArrayList<Curso> cursosRequeridos) {
        this.cursosRequeridos = cursosRequeridos;
    }
}