/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.model.GestNotificaciones;

import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class Notificacion {
    private int idNotificacion;
    private int idUsiarioNotificado;
    private Date fecha;
    private boolean leido;
    private int tipo;
    // 0Admin 1Amistad; 2Curso; 3Evento; 4Post
    private int subTipo;
    
    private Usuario usuarioNotificador;
    private Curso cursoFavorito;
    private Evento eventoAgendado;
    private Post post;

    public int getIdUsiarioNotificado() {
        return idUsiarioNotificado;
    }

    public void setIdUsiarioNotificado(int idUsiarioNotificado) {
        this.idUsiarioNotificado = idUsiarioNotificado;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(int subTipo) {
        this.subTipo = subTipo;
    }

    public Usuario getUsuarioNotificador() {
        return usuarioNotificador;
    }

    public void setUsuarioNotificador(Usuario usuarioNotificador) {
        this.usuarioNotificador = usuarioNotificador;
    }

    public Curso getCursoFavorito() {
        return cursoFavorito;
    }

    public void setCursoFavorito(Curso cursoFavorito) {
        this.cursoFavorito = cursoFavorito;
    }

    public Evento getEventoAgendado() {
        return eventoAgendado;
    }

    public void setEventoAgendado(Evento eventoAgendado) {
        this.eventoAgendado = eventoAgendado;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }
    
    
}
