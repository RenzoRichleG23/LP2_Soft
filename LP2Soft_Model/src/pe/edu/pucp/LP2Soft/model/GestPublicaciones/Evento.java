/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;
import java.util.Date;

public class Evento extends Post{
    //private int idEvento; 
    private String nombreDelEvento;
    private Date fechaDelEvento;
    private int horaInicio;
    private int horaFin;
    private String enlaceZoom;
    private byte[] archivo;
    // Constructor
    public Evento(String nombreDelEvento,Date fechaDelEvento,String comentarioPost,int prioridad) {
        super(comentarioPost,prioridad);
        super.setTipo(2);
        super.setBloqueado(false);
        this.nombreDelEvento=nombreDelEvento;
        this.fechaDelEvento = fechaDelEvento;
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

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public String getEnlaceZoom() {
        return enlaceZoom;
    }

    public void setEnlaceZoom(String enlaceZoom) {
        this.enlaceZoom = enlaceZoom;
    }
}
