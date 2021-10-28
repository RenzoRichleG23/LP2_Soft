/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class NotificacionPost extends Notificacion {
    /* Mostrar: Información de "publicacion" */
    // "usuario2" ha comentado tu publicación "publicación": 1
    // a "usuario2" le gusta tu publicación "publicación": 1
    private Post publicacion;
    private boolean estaComentado; // true: 1 / false: 0
    private Usuario usuario2;

    NotificacionPost() {
        super.setTipo(4);
    }
    public Post getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Post publicacion) {
        this.publicacion = publicacion;
    }

    public boolean isEstaComentado() {
        return estaComentado;
    }

    public void setEstaComentado(boolean estaComentado) {
        this.estaComentado = estaComentado;
    }   

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
    
}
