/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;

public class NotificacionPost extends Notificacion {
    /* Mostrar: Información de "publicacion" */
    // "nombreUsuario" ha comentado tu publicación "publicación": 1
    // a "nombreUsuario" le gusta tu publicación "publicación": 1
    private Post publicacion;
    private boolean estaComentado; // true: 1 / false: 0
    private String nombreUsuario;

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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
}
