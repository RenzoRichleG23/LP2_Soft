/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.model.GestPublicaciones;

public class Material extends Post {
    private byte[] archivo;
    // Constructor
    public Material(byte[] archivo, String comentarioPost) {
        super(comentarioPost);
        this.archivo = archivo;
    }
    // Getters
    public byte[] getArchivo() {
        return archivo;
    }
    // Setters
    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
}
