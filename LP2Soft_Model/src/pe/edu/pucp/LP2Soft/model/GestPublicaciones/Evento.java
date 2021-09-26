/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.Date;

public class Evento extends Post{
    private String descripcion;
    private Date fechaDelEvento;
    private byte[] archivo;
    // Constructor
    public Evento(Date fecha, byte[] archivo, String descripcion, String comentarioPost) {
        super(comentarioPost);
        this.fechaDelEvento = fecha;
        this.archivo = archivo;
        this.descripcion = descripcion;
    }
    // Getters
    public Date getFechaDelEvento() {
        return fechaDelEvento;
    }
    public byte[] getArchivo() {
        return archivo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    // Setters
    public void setFechaDelEvento(Date fechaDelEvento) {
        this.fechaDelEvento = fechaDelEvento;
    }
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
