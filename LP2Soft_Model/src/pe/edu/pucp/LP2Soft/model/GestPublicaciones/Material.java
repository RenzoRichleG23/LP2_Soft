/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;

import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;

public class Material extends Post {
    private byte[] archivo;
    private String nombreArchivo;
    private Curso curso;
    private int cantidadCalificaiones;
    private int sumatoriaCalificaiones;
    private Profesor profesor;
    // Constructor
    public Material(byte[] archivo, String comentarioPost) {
        super(comentarioPost);
        this.archivo = archivo;
    }
    
    public Material(String nombreArchivo,String comentarioPost,int prioridad) {
        super(comentarioPost,prioridad);
        this.nombreArchivo=nombreArchivo;
    }
    
    public Material(){}
    
    // Getters
    public byte[] getArchivo() {
        return archivo;
    }
    // Setters
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
