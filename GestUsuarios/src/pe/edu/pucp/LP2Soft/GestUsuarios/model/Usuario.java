/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestUsuarios.model;
import pe.edu.pucp.LP2Soft.GestCursos.model.Curso;
import pe.edu.pucp.LP2Soft.GestPublicaciones.model.Post;
import pe.edu.pucp.LP2Soft.GestPublicaciones.model.Resenia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Usuario {
    private int codigoPUCP;
    private String nombre;
    private String correo;
    private String especialidad;
    private String contrasenia;
    private Date fechaNacimiento;
    private String descripcion;
    private byte[] foto;
    private int tipo;
    private boolean esActivo;
    private float creditosTotales;
    private boolean esAsesor;
    private boolean esAdmin;
    
//    private Asesor asesor; // Cómo se implementa una agregación?
    private ArrayList<Post> posts;
    private ArrayList<Curso> cursosAprobados;
    private ArrayList<Usuario> amigos;
    private ArrayList<Resenia> resenias;
    private Calendar calendario;   // Cómo lo implementamos?
    
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
        this.esActivo = true;
        this.tipo = 0;
        this.creditosTotales = 0;
        this.esAsesor = false;
        this.esAdmin = false;
        
        this.cursosAprobados = new ArrayList<Curso>();
        this.posts = new ArrayList<Post>();
        this.amigos = new ArrayList<Usuario>();
        this.resenias = new ArrayList<Resenia>();
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
    public int getTipo() {
        return tipo;
    }
    public boolean isEsActivo() {
        return esActivo;
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
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
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
    
}
