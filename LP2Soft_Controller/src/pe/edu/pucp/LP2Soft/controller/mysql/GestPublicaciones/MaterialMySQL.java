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
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.MaterialDAO;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Material;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public class MaterialMySQL implements MaterialDAO{
    //Permite conectarnos
    Connection con;
    //Permite ejecutar una instrucción SQL dentro del motor de Base de Datos
    ResultSet rs;
    PreparedStatement ps;
    CallableStatement cs;
    
    @Override
    public int insertar(Material material) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            
            cs = con.prepareCall("{call INSERTAR_MATERIAL(?,?,?,?,?,?,?,?,?,?,?)}");
            
            cs.registerOutParameter("_idPost",java.sql.Types.INTEGER);
            cs.setInt("_fidUsuario",material.getUsuario().getCodigoPUCP());
            //cs.setInt("_fidCurso",material.getCurso().getIdCurso());
            cs.setInt("_fidCurso", 1);
            cs.setString("_comentarioPost",material.getComentarioPost());
            cs.setInt("_bloqueado", 0);
            cs.setInt("_likes", 0);
            cs.setInt("_prioridad",material.getPrioridad());
            cs.setDate("_fechaRegistro",new java.sql.Date(material.getFechaRegistro().getTime()));
            cs.setInt("_activo", 1);
            cs.setString("_nombreArchivo",material.getNombreArchivo());
            File file=new File(material.getNombreArchivo());
            FileInputStream input = new FileInputStream(file);
            cs.setBlob("_archivo",input);
            
            cs.executeUpdate();
            material.setIdPost(cs.getInt("_idPost"));
            
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
    public int modificar(Material material) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            
            cs = con.prepareCall("{call MODIFICAR_MATERIAL(?,?,?,?,?)}");
      
            cs.setInt("_idPost",material.getIdPost());
            cs.setInt("_fidCurso", 1);
            cs.setString("_comentarioPost",material.getComentarioPost());
            if(material.getBloqueado()==false)
                cs.setInt("_bloqueado", 0);
            else
                cs.setInt("_bloqueado", 1);
            cs.setInt("_likes", material.getLikes());
            
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
    public int eliminar(int idMaterial) {
        int resultado=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            
            cs = con.prepareCall("{call ELIMINAR_MATERIAL(?)}");
      
            cs.setInt("_idPost",idMaterial);
            
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
    public ArrayList<Material> listarTodos() {
        ArrayList<Material> materiales = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.url,DBManager.user,DBManager.password);
            cs = con.prepareCall("{call LISTAR_MATERIALES()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Material material = new Material();
                material.setIdPost(rs.getInt("idPost"));
                Usuario usuario=new Usuario();
                usuario.setCodigoPUCP(rs.getInt("fidUsuario"));
                material.setUsuario(usuario);
                material.setComentarioPost(rs.getString("comentarioPost"));
                if(rs.getInt("bloqueado")==1)
                    material.setBloqueado(true);
                else
                    material.setBloqueado(false);
                material.setLikes(rs.getInt("likes"));
                material.setPrioridad(rs.getInt("prioridad"));
                material.setFechaRegistro(rs.getDate("fechaRegistro"));
                material.setActivo(true);
                Curso curso=new Curso();
                //necesito en idCurso
                //...
                material.setNombreArchivo(rs.getString("nombreArchivo"));
                File file = new File(material.getNombreArchivo());
                FileOutputStream output = new FileOutputStream(file);
                InputStream input = rs.getBinaryStream("archivo");
                byte[] buffer = new byte[1024];
                while(input.read(buffer)>0){
                    output.write(buffer);
                }
                materiales.add(material);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return materiales;
    }
    
}
