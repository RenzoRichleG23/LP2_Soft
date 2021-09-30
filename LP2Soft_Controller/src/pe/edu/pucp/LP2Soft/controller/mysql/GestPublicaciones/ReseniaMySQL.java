/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ReseniaDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class ReseniaMySQL implements ReseniaDAO{
    
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    CallableStatement cs;
    @Override
    public int insertar(Resenia resenia) {
    int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url, DBManager.user, DBManager.password);
            
            cs = con.prepareCall("{call INSERTAR_POST(?,?,?,?,?,?,?)}");
            
            cs.registerOutParameter("_id_post", java.sql.Types.INTEGER);
            
            cs.setInt("_fidUsuario", resenia.getUsuario().getCodigoPUCP());
            cs.setString("_comentarioPost", resenia.getComentarioPost());
            cs.setDate("_fechaRegistro", new java.sql.Date(resenia.getFechaRegistro().getTime()));
            cs.setInt("_fidProfesor", resenia.getProfesor().getIdProfesor());
            cs.setInt("_fidUsuarioReseniado", resenia.getUsuarioReseniado().getCodigoPUCP());
            cs.setString("_calificacion", resenia.getComentarioPost());
            
            cs.executeUpdate();
            resenia.setIdPost(cs.getInt("_id_post"));
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{cs.close();}catch(Exception ex){System.out.println(ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());};
        }
        return resultado;
    }

    @Override
    public int meodificar(Resenia resenia) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            
            cs = con.prepareCall("{call MODIFICAR_RESENIA(?,?,?,?,?)}");
      
            cs.setInt("_idPost", resenia.getIdPost());
            cs.setString("_comentarioPost", resenia.getComentarioPost());
            
            if(resenia.isBloqueado() == true){
                cs.setInt("_bloqueado", 1);
            }else{
                cs.setInt("_bloqueado", 0);
            }
            
            cs.setInt("_prioridad", resenia.getPrioridad());
            if(resenia.isActivo()== true){
                cs.setInt("_activo", 1);
            }else{
                cs.setInt("_activo", 0);
            }
            cs.setInt("_calificacion", resenia.getCalificacion());
            cs.executeUpdate();
            
            resultado=1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return resultado;   }

    @Override
    public int eliminar(Resenia resenia) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            
            cs = con.prepareCall("{call ELIMINAR_RESENIA(?)}");
      
            cs.setInt("_idPost",resenia.getIdPost());
            
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
    public ArrayList<Resenia> listarTodos() {
    ArrayList<Resenia> resenias = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            cs = con.prepareCall("{call LISTAR_POST()}");
            rs = cs.executeQuery();
            while(rs.next()){
                
                Resenia resenia = new Resenia();
                resenia.setIdPost(rs.getInt("idPost"));
                Usuario usuario = new Usuario();
                usuario.setCodigoPUCP(rs.getInt("fidUsuario"));
                resenia.setUsuario(usuario);
                resenia.setComentarioPost(rs.getString("comentarioPost"));
                if(rs.getInt("bloqueado")==1)
                    resenia.setBloqueado(true);
                else
                    resenia.setBloqueado(false);
                
                resenia.setLikes(rs.getInt("likes"));
                resenia.setPrioridad(rs.getInt("prioridad"));
                resenia.setFechaRegistro(rs.getDate("fechaRegistro"));
                resenia.setActivo(true);
                
                
                //ahora lo de resenia 
                
                Profesor profe = new Profesor();
                profe.setIdProfesor(rs.getInt("fidProfesor"));
                Usuario usuarioReseniado = new Usuario();
                usuarioReseniado.setCodigoPUCP(rs.getInt("fidUsuarioReseniado"));
                resenia.setProfesor(profe);
                resenia.setUsuarioReseniado(usuarioReseniado);
                
                resenia.setCalificacion(rs.getInt("calificacion"));
                
                resenias.add(resenia);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return resenias;
    }
    

}