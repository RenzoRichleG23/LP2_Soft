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
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.MensajeDAO;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.Mensaje;
import pe.edu.pucp.LP2Soft.model.GestNotificaciones.UltimoMensaje;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class MensajeMySQL implements MensajeDAO {
    Connection con;
    ResultSet rs;
    ResultSet rs2;
    CallableStatement cs;
    CallableStatement cs2;
    
    @Override
    public int enviarMensaje(int idUsuario1, int idUsuario2, String contenido) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ENVIAR_MENSAJE(?,?,?)}");
            cs.setInt("_idUsuario1", idUsuario1);
            cs.setInt("_idUsuario2", idUsuario2);
            cs.setString("_contenido", contenido);
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
    public ArrayList<Mensaje> listarMensajesXAmigo(int idUsuario1, int idUsuario2) {
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MENSAJES_AMIGO(?,?)}");
            cs.setInt("_idUsuario1", idUsuario1);
            cs.setInt("_idUsuario2", idUsuario2);
            rs = cs.executeQuery();
            while(rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setIdMensaje(rs.getInt("idMensaje"));
                mensaje.setIdRemitente(rs.getInt("fidUsuario1"));
                mensaje.setIdDestinatario(rs.getInt("fidUsuario2"));
                mensaje.setContenido(rs.getString("contenido"));
                mensaje.setFechayHora(rs.getDate("fecha"));
                if(rs.getInt("leido")==1) mensaje.setLeido(true);
                mensajes.add(mensaje);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return mensajes;
    }

    @Override
    public ArrayList<UltimoMensaje> listarUltimosMensajes(int idUsuario) {
        ArrayList<UltimoMensaje> mensajes = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MENSAJES_ULTIMOS(?)}");
            cs.setInt("_idUsuario", idUsuario);
            rs = cs.executeQuery();
            
            int id1 = 0;
            int id2 = 0;
            boolean ok = false;
            while(rs.next()) {
                UltimoMensaje mensaje = new UltimoMensaje();
                ok = true;
                id1 = rs.getInt("fidUsuario1");
                id2 = rs.getInt("fidUsuario2");
                
                for(UltimoMensaje m : mensajes) {
                    if(m.getMensaje().getIdRemitente()==id2 && m.getMensaje().getIdDestinatario()==id1) {
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    mensaje.setMensaje(new Mensaje());
                    mensaje.getMensaje().setIdMensaje(rs.getInt("idMensaje"));
                    mensaje.getMensaje().setIdRemitente(rs.getInt("fidUsuario1"));
                    mensaje.getMensaje().setIdDestinatario(rs.getInt("fidUsuario2"));
                    mensaje.getMensaje().setContenido(rs.getString("contenido"));
                    mensaje.getMensaje().setFechayHora(rs.getDate("fecha"));
                    if(rs.getInt("leido")==1) mensaje.getMensaje().setLeido(true);
                    //traer los datos del amigo
                    int idAmigo = (id1==idUsuario)? id2: id1;
                    cs2 = con.prepareCall("{call MOSTAR_USUARIO_CORTO(?)}");
                    cs2.setInt("_idUsuario", idAmigo);
                    rs2 = cs2.executeQuery();
                    if(rs2.next()) {
                        mensaje.setAmigo(new Usuario());
                        mensaje.getAmigo().setIdUsuario(idAmigo);
                        mensaje.getAmigo().setNombre(rs2.getString("nombre"));
                        mensaje.getAmigo().setApellido(rs2.getString("apellido"));
                        mensaje.getAmigo().setFoto(rs2.getBytes("foto"));
                    }
                    mensajes.add(mensaje);
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {cs.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
            try {con.close();} catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        return mensajes;
    }
}
