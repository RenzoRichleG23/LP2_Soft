/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.Date;

public class Evento extends Post{
    //private int idEvento; 
    private String nombreDelEvento;
    private Date fechaDelEvento;
    private String nombreArchivo;
    private byte[] archivo;
    // Constructor
    public Evento(String nombreDelEvento,Date fechaDelEvento,String nombreArchivo,String comentarioPost,int prioridad) {
        super(comentarioPost,prioridad);
        super.setTipo(2);
        super.setBloqueado(false);
        this.nombreDelEvento=nombreDelEvento;
        this.fechaDelEvento = fechaDelEvento;
        this.nombreArchivo = nombreArchivo;
    }
    
    public Evento(){}
    
    // Getters
    public Date getFechaDelEvento() {
        return fechaDelEvento;
    }
    public byte[] getArchivo() {
        return archivo;
    }

    // Setters
    public void setFechaDelEvento(Date fechaDelEvento) {
        this.fechaDelEvento = fechaDelEvento;
    }
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getNombreDelEvento() {
        return nombreDelEvento;
    }

    public void setNombreDelEvento(String nombreDelEvento) {
        this.nombreDelEvento = nombreDelEvento;
    }

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
