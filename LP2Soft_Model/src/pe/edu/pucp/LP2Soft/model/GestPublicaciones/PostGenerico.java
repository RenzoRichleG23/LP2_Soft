/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestPublicaciones;

public class PostGenerico extends Post {
    public PostGenerico(String comentarioPost) {
        super(comentarioPost);
        super.setBloqueado(false);
        super.setTipo(1);
    }
    
    public PostGenerico(){}
}
