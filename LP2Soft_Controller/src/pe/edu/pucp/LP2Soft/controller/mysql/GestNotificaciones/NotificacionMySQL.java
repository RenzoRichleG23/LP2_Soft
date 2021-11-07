/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestNotificaciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestNotificaciones.NotificacionDAO;

public class NotificacionMySQL implements NotificacionDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    CallableStatement cs;
    @Override
    public int insertarNotificacionAdmin(int idUsuario) {
        int resultado=0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_NOTIFICACION_ADMIN(?)}");
            cs.setInt("_idUsuario", idUsuario);
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
