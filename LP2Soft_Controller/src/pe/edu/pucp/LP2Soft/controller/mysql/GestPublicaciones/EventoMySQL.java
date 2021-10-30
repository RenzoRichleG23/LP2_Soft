/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.EventoDAO;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class EventoMySQL implements EventoDAO{
    //Permite conectarnos
    Connection con;
    //Permite ejecutar una instrucción SQL dentro del motor de Base de Datos
    ResultSet rs;
    PreparedStatement ps;
    CallableStatement cs;
    
    @Override
    public int insertar(Evento evento) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EVENTO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idPost",java.sql.Types.INTEGER);
            cs.setInt("_fidUsuario",evento.getUsuario().getCodigoPUCP());
            cs.setString("_comentarioPost",evento.getContenido());
            cs.setInt("_bloqueado", 0);
            cs.setInt("_likes", 0);
            cs.setInt("_prioridad",evento.getPrioridad());
            cs.setDate("_fechaRegistro",new java.sql.Date(evento.getFechaRegistro().getTime()));
            cs.setInt("_activo", 1);
            cs.setString("_nombreDelEvento", evento.getNombreDelEvento());
            cs.setDate("_fechaDelEvento",new java.sql.Date(evento.getFechaDelEvento().getTime()));
            cs.setString("_nombreArchivo",evento.getNombreArchivo());
            File file=new File(evento.getNombreArchivo());
            FileInputStream input = new FileInputStream(file);
            cs.setBlob("_archivo",input);
            
            cs.executeUpdate();
            evento.setIdPost(cs.getInt("_idPost"));
            
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return resultado;
    }

    @Override
    public int modificar(Evento evento) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_EVENTO(?,?,?,?,?,?)}");
      
            cs.setInt("_idPost",evento.getIdPost());
            cs.setString("_comentarioPost",evento.getContenido());
            if(evento.getBloqueado()==false)
                cs.setInt("_bloqueado", 0);
            else
                cs.setInt("_bloqueado", 1);
            cs.setInt("_likes", evento.getLikes());
            cs.setString("_nombreDelEvento", evento.getNombreDelEvento());
            cs.setDate("_fechaDelEvento",new java.sql.Date(evento.getFechaDelEvento().getTime()));
            /*File file=new File(evento.getNombreArchivo());
            FileInputStream input = new FileInputStream(file);
            cs.setBlob("_archivo",input);*/
            
            cs.executeUpdate();
            
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return resultado;
    }

    @Override
    public int eliminar(int idEvento) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_EVENTO(?)}");
      
            cs.setInt("_idPost",idEvento);
            
            cs.executeUpdate();
            
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return resultado;
    }

    @Override
    public ArrayList<Evento> listarTodos() {
        ArrayList<Evento> eventos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EVENTOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Evento evento = new Evento();
                evento.setIdPost(rs.getInt("idPost"));
                Usuario usuario=new Usuario();
                usuario.setCodigoPUCP(rs.getInt("fidUsuario"));
                evento.setUsuario(usuario);
                evento.setContenido(rs.getString("comentarioPost"));
                if(rs.getInt("bloqueado")==1)
                    evento.setBloqueado(true);
                else
                    evento.setBloqueado(false);
                evento.setLikes(rs.getInt("likes"));
                evento.setPrioridad(rs.getInt("prioridad"));
                evento.setFechaRegistro(rs.getDate("fechaRegistro"));
                evento.setActivo(true);
                evento.setNombreDelEvento(rs.getString("nombreDelEvento"));
                evento.setFechaDelEvento(rs.getDate("fechaDelEvento"));
                evento.setNombreArchivo(rs.getString("nombreArchivo"));
                File file = new File(evento.getNombreArchivo());
                FileOutputStream output = new FileOutputStream(file);
                InputStream input = rs.getBinaryStream("archivo");
                byte[] buffer = new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
                eventos.add(evento);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return eventos;
    }
}
