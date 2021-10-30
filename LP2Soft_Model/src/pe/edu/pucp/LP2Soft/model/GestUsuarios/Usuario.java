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
    private int idUsuario;
    private String nombre;
    private String codigoPUCP;
    private String apellido;
    private String correo;
    private String especialidad;
    private String contrasenia;
    private String descripcion;
    private Date fechaNacimiento;
    private byte[] foto;
    private byte[] portada;
    private float creditosTotales;
    private boolean activo;
    private boolean esAsesor;
    private boolean esAdmin;
    
    private Asesor asesor;
    private ArrayList<Post> posts;
    private ArrayList<Curso> cursos;
    private ArrayList<Usuario> amigos;
    private ArrayList<Evento> eventosAgendados;
    
    // Constructor
    public Usuario() {
        this.especialidad = "Ing. Informática";
        this.activo = true;
        this.creditosTotales = 0;
        this.esAsesor = false;
        this.esAdmin = false;
        
        this.cursos = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.amigos = new ArrayList<>();
        this.eventosAgendados = new ArrayList<>();
        this.asesor = null; // Agregación
    }
    public String getCodigoPUCP() {
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
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }
    public Asesor getAsesor() {
        return asesor;
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
    public void seraAsesor(float precioxHora) {
        this.esAsesor = true;
        this.asesor = new Asesor(precioxHora);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public ArrayList<Evento> getEventosAgendados() {
        return eventosAgendados;
    }

    public void setEventosAgendados(ArrayList<Evento> eventosAgendados) {
        this.eventosAgendados = eventosAgendados;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setCodigoPUCP(String codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }
    
}
