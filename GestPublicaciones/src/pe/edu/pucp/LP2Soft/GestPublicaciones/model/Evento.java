/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestPublicaciones.model;
import java.util.Date;

public class Evento extends Post{
    private int idEvento;
    private Date fechaDelEvento;
    private byte[] archivo;
    // Constructor
    public Evento(int idEvento, Date fecha, byte[] archivo, int idPost,
            String comentarioPost, int likes, int prioridad) {
        super(idPost, comentarioPost, likes, prioridad);
        this.fechaDelEvento = fecha;
        this.idEvento = idEvento;
        this.archivo = archivo;
    }
    // Getters
    public int getIdEvento() {
        return idEvento;
    }
    public Date getFechaDelEvento() {
        return fechaDelEvento;
    }
    public byte[] getArchivo() {
        return archivo;
    }
    // Setters
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public void setFechaDelEvento(Date fechaDelEvento) {
        this.fechaDelEvento = fechaDelEvento;
    }
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
    
}
