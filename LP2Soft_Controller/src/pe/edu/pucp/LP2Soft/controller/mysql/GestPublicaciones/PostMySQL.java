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
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

//public class PostMySQL implements PostDAO{

//    Connection con;
//    ResultSet rs;
//    PreparedStatement ps;
//    CallableStatement cs;
//    @Override
//    public int insertar(Post post) {
//        int resultado = 0;
//        try{
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call INSERTAR_POST(?,?,?,?)}");
//            
//            cs.registerOutParameter("_id_post", java.sql.Types.INTEGER);
//            
//            cs.setInt("_fidUsuario", post.getUsuario().getCodigoPUCP());
//            cs.setString("_comentarioPost", post.getContenido());
//            cs.setDate("_fechaRegistro", new java.sql.Date(post.getFechaRegistro().getTime()));
//            
//            cs.executeUpdate();
//            
//            post.setIdPost(cs.getInt("_id_post"));
//            resultado=1;
//            
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{cs.close();}catch(Exception ex){System.out.println(ex.getMessage());};
//            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());};
//        }
//        return resultado;
//    }
//
//    @Override
//    public int meodificar(Post post) {
//        int resultado=0;
//        try{
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call MODIFICAR_POST(?,?,?,?,?)}");
//      
//            cs.setInt("_idPost", post.getIdPost());
//            cs.setString("_comentarioPost", post.getContenido());
//            
//            if(post.isBloqueado() == true){
//                cs.setInt("_bloqueado", 1);
//            }else{
//                cs.setInt("_bloqueado", 0);
//            }
//            
//            cs.setInt("_prioridad", post.getPrioridad());
//            if(post.isActivo()== true){
//                cs.setInt("_activo", 1);
//            }else{
//                cs.setInt("_activo", 0);
//            }
//            
//            cs.executeUpdate();
//            
//            resultado=1;
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//        }
//        return resultado;
//    }
//
//    @Override
//    public int eliminar(Post post) {
//        int resultado=0;
//        try{
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call ELIMINAR_POST(?)}");
//      
//            cs.setInt("_idPost",post.getIdPost());
//            
//            cs.executeUpdate();
//            
//            resultado=1;
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//        }
//        return resultado;
//    }
//
//    @Override
//    public ArrayList<Post> listarTodos() {
//        ArrayList<Post> posts = new ArrayList<>();
//        try{
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call LISTAR_POST()}");
//            rs = cs.executeQuery();
//            while(rs.next()){
//                
//                Post post = new Post();
//                post.setIdPost(rs.getInt("idPost"));
//                Usuario usuario = new Usuario();
//                usuario.setCodigoPUCP(rs.getInt("fidUsuario"));
//                post.setUsuario(usuario);
//                post.setContenido(rs.getString("comentarioPost"));
//                if(rs.getInt("bloqueado")==1)
//                    post.setBloqueado(true);
//                else
//                    post.setBloqueado(false);
//                
//                post.setLikes(rs.getInt("likes"));
//                post.setPrioridad(rs.getInt("prioridad"));
//                post.setFechaRegistro(rs.getDate("fechaRegistro"));
//                post.setActivo(true);
//                
//                posts.add(post);
//            }
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
//        }
//        return posts;
//    }
//    

//}
