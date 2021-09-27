/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.Date;

public class Evento extends Post{
    //private int idEvento; 
    //private String descripcion;
    private Date fechaDelEvento;
    private String nombreArchivo;
    private byte[] archivo;
    // Constructor
    public Evento(Date fechaDelEvento,String nombreArchivo,String comentarioPost,int prioridad) {
        super(comentarioPost,prioridad);
        this.fechaDelEvento = fechaDelEvento;
        this.nombreArchivo = nombreArchivo;
        //this.descripcion = descripcion;
    }
    
    public Evento(){}
    
    // Getters
    public Date getFechaDelEvento() {
        return fechaDelEvento;
    }
    public byte[] getArchivo() {
        return archivo;
    }

    /*public String getDescripcion() {
        return descripcion;
    }*/
    // Setters
    public void setFechaDelEvento(Date fechaDelEvento) {
        this.fechaDelEvento = fechaDelEvento;
    }
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    /*public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }*/

    /*public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }*/

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
