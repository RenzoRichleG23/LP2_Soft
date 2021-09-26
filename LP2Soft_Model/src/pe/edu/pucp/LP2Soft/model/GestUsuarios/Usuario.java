/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestUsuarios;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;

public class Usuario {
    private int codigoPUCP;
    private String nombre;
    private String correo;
    private String especialidad;
    private String contrasenia;
    private String descripcion;
    private Date fechaNacimiento;
    private byte[] foto;
    private float creditosTotales;
    private boolean activo;
    private boolean esAsesor;
    private boolean esAdmin;
    
    private Asesor asesor; // Agregación
    private ArrayList<Post> posts;
    private ArrayList<Curso> cursosAprobados;
    private ArrayList<Usuario> amigos;
    private ArrayList<Resenia> resenias;
    private ArrayList<Evento> fechas;   // Cómo lo implementamos?
    
    
    // Constructor
    public Usuario(int codigoPUCP, String nombre, String correo, String especialidad,
            String contrasenia, Date fechaNacimiento, String descripcion) {
        this.codigoPUCP = codigoPUCP;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidad = especialidad;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.descripcion = descripcion;
        this.activo = true;
        this.creditosTotales = 0;
        this.esAsesor = false;
        this.esAdmin = false;
        
        this.cursosAprobados = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.amigos = new ArrayList<>();
        this.resenias = new ArrayList<>();
        this.asesor = null; // Agregación
    }
    // Getters
    public int getCodigoPUCP() {
        return codigoPUCP;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public byte[] getFoto() {
        return foto;
    }
    public float getCreditosTotales() {
        return creditosTotales;
    }
    public boolean isEsAsesor() {
        return esAsesor;
    }
    public boolean isEsAdmin() {
        return esAdmin;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }
    public ArrayList<Curso> getCursosAprobados() {
        return cursosAprobados;
    }
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }
    public ArrayList<Resenia> getResenias() {
        return resenias;
    }
    public Asesor getAsesor() {
        return asesor;
    }
    // Setters
    public void setCodigoPUCP(int codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public void setActivo(boolean esActivo) {
        this.activo = esActivo;
    }
    public void setCreditosTotales(float creditosTotales) {
        this.creditosTotales = creditosTotales;
    }
    public void setEsAsesor(boolean esAsesor) {
        this.esAsesor = esAsesor;
    }
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    // métodos
    public void seraAsesor(float precioxHora, Ubicacion ubicacion) {
        this.esAsesor = true;
        this.asesor = new Asesor(precioxHora, ubicacion);
        
    }
}
