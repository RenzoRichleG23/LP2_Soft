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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            cs = con.prepareCall("{call INSERTAR_EVENTO(?,?,?,?,?,?,?,?,?,?,?)}");
            
            cs.registerOutParameter("_idPost",java.sql.Types.INTEGER);
            
            cs.setInt("_fidUsuario",evento.getUsuario().getIdUsuario());
            cs.setString("_contenido",evento.getContenido());
            cs.setInt("_prioridad",evento.getPrioridad());
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dt = new Date();
            evento.setFechaRegistro(formato.parse(formato.format(dt)));
            
            cs.setDate("_fechaRegistro", new java.sql.Date(evento.getFechaRegistro().getTime()));
            
            
            cs.setString("_tituloEvento", evento.getNombreDelEvento());
            cs.setDate("_fechaDelEvento",new java.sql.Date(evento.getFechaDelEvento().getTime()));
            cs.setInt("_horaInicio",evento.getHoraInicio());
            cs.setInt("_horaFin",evento.getHoraFin());
            cs.setString("_enlaceZoom",evento.getEnlaceZoom());
            cs.setBytes("_archivo", evento.getArchivo());
            
            /*cs.setString("_nombreArchivo",evento.getNombreArchivo());
            File file=new File(evento.getNombreArchivo());
            FileInputStream input = new FileInputStream(file);
            cs.setBlob("_archivo",input);*/
            
            cs.executeUpdate();
            evento.setIdPost(cs.getInt("_idPost"));
            
            resultado=evento.getIdPost();
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
    public ArrayList<Evento> listarMisEventos(int idUsuario) {
        ArrayList<Evento> eventos = new ArrayList<>();
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MIS_EVENTOS(?)}");
            cs.setInt("_idUsuario",idUsuario);
            rs = cs.executeQuery();
            while(rs.next()){
                Evento evento = new Evento();
                evento.setIdPost(rs.getInt("idPost"));
                evento.setFechaRegistro(rs.getDate("fechaRegistro"));
                evento.setNombreDelEvento(rs.getString("tituloEvento"));
                evento.setContenido(rs.getString("contenido"));
                evento.setEnlaceZoom(rs.getString("enlaceZoom"));
                evento.setFechaDelEvento(rs.getDate("fechaDelEvento"));
                evento.setHoraInicio(rs.getInt("horaInicio"));
                evento.setHoraFin(rs.getInt("horaFin"));
                evento.setArchivo(rs.getBytes("archivo"));
                eventos.add(evento);
            }
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        if(resultado==1)
            return eventos;
        else
            return null;
    }
    
    @Override
    public ArrayList<Evento> listarTodos() {
        int resultado=0;
        ArrayList<Evento> eventos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EVENTOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Evento evento = new Evento();
                Usuario usuario=new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                evento.setUsuario(usuario);
                evento.setIdPost(rs.getInt("idPost"));
                evento.setLikes(rs.getInt("likes"));
                evento.setNumeroComent(rs.getInt("numeroComent"));
                evento.setFechaRegistro(rs.getDate("fechaRegistro"));
                evento.setNombreDelEvento(rs.getString("tituloEvento"));
                evento.setContenido(rs.getString("contenido"));
                evento.setEnlaceZoom(rs.getString("enlaceZoom"));
                evento.setFechaDelEvento(rs.getDate("fechaDelEvento"));
                evento.setHoraInicio(rs.getInt("horaInicio"));
                evento.setHoraFin(rs.getInt("horaFin"));
                evento.setArchivo(rs.getBytes("archivo"));
                eventos.add(evento);
            }
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        if(resultado==1)
            return eventos;
        else
            return null;
    }
}
