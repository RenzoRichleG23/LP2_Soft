/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

public class NotificacionCurso extends Notificacion {
    /* Mostrar: Información del "cursoFavorito" */
    // "nombreUsuario" ha subido nuevo material al curso "cursoFavorito"
    private Curso cursoFavorito;
    private String nombreUsuario;

    public Curso getCursoFavorito() {
        return cursoFavorito;
    }

    public void setCursoFavorito(Curso cursoFavorito) {
        this.cursoFavorito = cursoFavorito;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
}
