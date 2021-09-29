/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestUsuarios;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

import java.util.ArrayList;
public class Asesor{
    private int idAsesor;
    private float calificacion;
    private float precioPorHora;
    private boolean activo;
    
    private Ubicacion ubicacion;
    private ArrayList<Curso>cursos;
    // Constructor
    public Asesor(){}
    public Asesor(float precioPorHora, Ubicacion ubicacion){
        this.cursos = new ArrayList<>();
        this.precioPorHora = precioPorHora;
        this.ubicacion = ubicacion;
        this.calificacion = 0;
        this.activo = true;
    }
    // Getters
    public int getIdAsesor(){
        return idAsesor;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public float getPrecioPorHora() {
        return precioPorHora;
    }
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    public boolean isActivo() {
        return activo;
    }
    
    // Setters
    public void setIdAsesor(int idAsesor) {
        this.idAsesor = idAsesor;
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public void setPrecioPorHora(float precioPorHora) {
        this.precioPorHora = precioPorHora;
    }
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}