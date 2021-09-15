/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.GestPublicaciones.model;
import java.util.Date;

public class Material extends Post {
    private int idMaterial;
    private byte[] archivo;
    // Constructor
    public Material(int idMaterial, byte[] archivo, int idPost,
            String comentarioPost, int likes, int prioridad) {
        super(idPost, comentarioPost, likes, prioridad);
        this.idMaterial = idMaterial;
        this.archivo = archivo;
    }
    // Getters
    public int getIdMaterial() {
        return idMaterial;
    }
    public byte[] getArchivo() {
        return archivo;
    }
    // Setters
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
}
