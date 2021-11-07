/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestNotificaciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.NotificacionDAO;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Notificacion;

public class NotificacionMySQL implements NotificacionDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;

//
//    @Override
//    public ArrayList<Notificacion> listarNotificaciones(int i) {
//        ArrayList<Notificacion> mensajes = new ArrayList<>();
//        try {
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call LISTAR_NOTIFICACIONES(?)}");
//            cs.setInt("_idUsuario1", idUsuario1);
//            cs.setInt("_idUsuario2", idUsuario2);
//            rs = cs.executeQuery();
//            while(rs.next()) {
//                Mensaje mensaje = new Mensaje();
//                mensaje.setIdMensaje(rs.getInt("idMensaje"));
//                mensaje.setIdRemitente(rs.getInt("fidUsuario1"));
//                mensaje.setIdDestinatario(rs.getInt("fidUsuario2"));
//                mensaje.setContenido(rs.getString("contenido"));
//                mensaje.setFechayHora(rs.getDate("fecha"));
//                if(rs.getInt("leido")==1) mensaje.setLeido(true);
//                mensajes.add(mensaje);
//            }
//        } catch(Exception ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
//            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
//        }
//        return mensajes;
//    }

    @Override
    public int insertarNotificacion(int idUsuarioNotificado, int tipo, int subTipo,
            int idUsuarioNotificador, int idCursoFavorito, int idEventoAgendado, int idPost) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_NOTIFICACION(?,?,?,?,?,?,?)}");
            cs.setInt("_idUsuarioNotificado", idUsuarioNotificado);
            cs.setInt("_tipo", tipo);
            cs.setInt("_subtipo", subTipo);
            cs.setInt("_idUsuarioNotificador", idUsuarioNotificador);
            cs.setInt("_idCursoFavorito", idCursoFavorito);
            cs.setInt("_idEventoAgendado", idEventoAgendado);
            cs.setInt("_idPost", idPost);
            resultado = cs.executeUpdate();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado; 
    }

}
