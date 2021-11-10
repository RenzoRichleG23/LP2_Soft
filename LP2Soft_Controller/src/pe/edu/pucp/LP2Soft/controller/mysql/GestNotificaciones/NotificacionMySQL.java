/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestNotificaciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.NotificacionDAO;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Notificacion;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class NotificacionMySQL implements NotificacionDAO {
    Connection con;
    ResultSet rs;
    CallableStatement cs;

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

    @Override
    public ArrayList<Notificacion> listarNotificaciones(int idUsuario) {
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_NOTIFICACIONES(?)}");
            cs.setInt("_idUsuario", idUsuario);
            rs = cs.executeQuery();
            while(rs.next()) {
                Timestamp ts1 = rs.getTimestamp("fecha");
                Notificacion notificacion = new Notificacion();
                notificacion.setIdNotificacion(rs.getInt("idNotificacion"));
                notificacion.setIdUsiarioNotificado(rs.getInt("fidUsuarioNotificado"));
                notificacion.setFecha(ts1);
                if(rs.getInt("leido")==1) notificacion.setLeido(true);
                notificacion.setTipo(rs.getInt("tipo"));
                notificacion.setSubTipo(rs.getInt("subTipo"));
                
                if(notificacion.getTipo()==1) {
                    notificacion.setUsuarioNotificador(new Usuario());
                    notificacion.getUsuarioNotificador().setIdUsuario(rs.getInt("idUsuarioNotificador"));
                    notificacion.getUsuarioNotificador().setNombre(rs.getString("nombreUsuarioNotificador"));
                    notificacion.getUsuarioNotificador().setCodigoPUCP(rs.getString("codigoUsuarioNotificador"));
                    notificacion.getUsuarioNotificador().setFoto(rs.getBytes("fotoUsuarioNotificador"));
                }
                notificaciones.add(notificacion);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return notificaciones;
    }

    @Override
    public int eliminarSolicitudAmistad(int idUsuarioNotificado, int idUsuarioNotificador) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_SOLICITUD_AMISTAD(?,?)}");
            cs.setInt("_idUsuario1", idUsuarioNotificado);
            cs.setInt("_idUsuario2", idUsuarioNotificador);
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
