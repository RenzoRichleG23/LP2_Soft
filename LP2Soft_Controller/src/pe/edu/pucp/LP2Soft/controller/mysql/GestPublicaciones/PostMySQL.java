/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;

import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class PostMySQL implements PostDAO{

    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    CallableStatement cs;
    
    @Override
    public int insertar(PostGenerico post) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_POST(?,?,?,?,?)}");
            
            cs.registerOutParameter("_idPost", java.sql.Types.INTEGER);
            
            cs.setInt("_fidUsuario", post.getUsuario().getIdUsuario());
            cs.setString("_contenido", post.getContenido());
            cs.setInt("_prioridad",post.getPrioridad());
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dt = new Date();
            post.setFechaRegistro(formato.parse(formato.format(dt)));
            
            cs.setDate("_fechaRegistro", new java.sql.Date(post.getFechaRegistro().getTime()));
            cs.executeUpdate();
            
            post.setIdPost(cs.getInt("_idPost"));
            resultado=post.getIdPost();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{cs.close();}catch(Exception ex){System.out.println(ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());};
        }
        return resultado;
    }

    @Override
    public int modificar(PostGenerico post) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_POST(?,?,?)}");
      
            cs.setInt("_idPost", post.getIdPost());
            cs.setString("_contenido", post.getContenido());
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date dt = new Date();
            post.setFechaRegistro(formato.parse(formato.format(dt)));
            
            cs.setDate("_fechaRegistro", new java.sql.Date(post.getFechaRegistro().getTime()));
//            if(post.isBloqueado() == true){
//                cs.setInt("_bloqueado", 1);
//            }else{
//                cs.setInt("_bloqueado", 0);
//            }
            
//            cs.setInt("_prioridad", post.getPrioridad());
//            if(post.isActivo()== true){
//                cs.setInt("_activo", 1);
//            }else{
//                cs.setInt("_activo", 0);
//            }
            
            
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
    public int eliminar(PostGenerico post) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_POST(?)}");
      
            cs.setInt("_idPost",post.getIdPost());
            
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
    public ArrayList<PostGenerico> listarTodos() {
        ArrayList<PostGenerico> posts = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_POST()}");
            rs = cs.executeQuery();
            while(rs.next()){
                
                PostGenerico post = new PostGenerico();
                post.setIdPost(rs.getInt("idPost"));
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("fidUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                //usuario.setFoto(rs.getBytes("foto"));
                post.setUsuario(usuario);
                post.setContenido(rs.getString("contenido"));
                if(rs.getInt("bloqueado")==1)
                    post.setBloqueado(true);
                else
                    post.setBloqueado(false);
                
                post.setLikes(rs.getInt("likes"));
                post.setPrioridad(rs.getInt("prioridad"));
                post.setFechaRegistro(rs.getDate("fechaRegistro"));
                post.setActivo(true);
                post.setTipo(1);
                post.setNumeroComent(rs.getInt("numeroComent"));
                posts.add(post);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return posts;
    }
}
