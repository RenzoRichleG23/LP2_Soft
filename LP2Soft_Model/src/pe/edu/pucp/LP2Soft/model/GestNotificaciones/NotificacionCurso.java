/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class NotificacionCurso extends Notificacion {
    /* Mostrar: Información del "cursoFavorito" */
    // "usuario2" ha subido nuevo material al curso "cursoFavorito"
    private Curso cursoFavorito;
    private Usuario usuario2;

    NotificacionCurso() {
        super.setTipo(2);
    }
    public Curso getCursoFavorito() {
        return cursoFavorito;
    }

    public void setCursoFavorito(Curso cursoFavorito) {
        this.cursoFavorito = cursoFavorito;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }
    
}
