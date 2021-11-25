/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;

public interface EventoDAO {
    int insertar(Evento evento);
    int modificar(Evento evento);
    int eliminar(int idEvento);
    ArrayList<Evento> listarMisEventos(int idUsuario);
    ArrayList<Evento> listarTodos();
    int agendarEvento(int idPost,int idUsuario);
    int desagendarEvento(int idPost,int idUsuario);
    int eventoAgendado(int idPost,int idUsuario);
    ArrayList<Evento> listarEventosAgendados(int idUsuario);
    ArrayList<Evento> listarEventosAgendadosFecha(int idUsuario,String fecha);
}
