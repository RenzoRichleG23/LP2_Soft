/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones;

import java.io.ByteArrayInputStream;
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
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;
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
    public int insertar_Material(Material material) {
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MATERIAL(?,?,?,?,?,?,?,?,?,?,?)}");            
            cs.registerOutParameter("_idPost",java.sql.Types.INTEGER);
            
            cs.setInt("_fidUsuario",material.getUsuario().getIdUsuario());
            cs.setString("_contenido",material.getContenido()); 
            
            cs.setInt("_fidCurso", material.getCurso().getIdCurso()); 
            cs.setInt("_fidCursoMaterial", material.getIdCurso());           
            cs.setInt("_fidProfesor", material.getProfesor().getIdProfesor());            
            cs.setString("_nombreArchivo", material.getNombreArchivo()); 
            
            cs.setBytes("_archivo",material.getArchivo());
            cs.setInt("_tipoMaterial", material.getTipoMaterial());
            cs.setInt("_indice_tipoMaterial", material.getIndice_tipoMaterial());
            cs.setString("_nota",material.getNota()); 
            cs.executeUpdate();
            material.setIdPost(cs.getInt("_idPost"));            
            resultado=material.getIdPost();
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
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_MATERIAL(?,?,?,?,?)}");
      
            cs.setInt("_idPost",material.getIdPost());
            cs.setString("_fidCurso",material.getCurso().getCodigo());
            cs.setString("_comentarioPost",material.getContenido());
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
            con = DBManager.getInstance().getConnection();
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
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MATERIALES()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Material material = new Material();
                material.setIdPost(rs.getInt("idPost"));
                Usuario usuario=new Usuario();
                usuario.setIdUsuario(rs.getInt("fidUsuario"));
                material.setUsuario(usuario);
                material.setContenido(rs.getString("comentarioPost"));
                if(rs.getInt("bloqueado")==1)
                    material.setBloqueado(true);
                else
                    material.setBloqueado(false);
                material.setLikes(rs.getInt("likes"));
                material.setPrioridad(rs.getInt("prioridad"));
                material.setFechaRegistro(rs.getDate("fechaRegistro"));
                material.setActivo(true);
                Curso curso=new Curso();
                curso.setCodigo(rs.getString("fidCurso"));
                material.setCurso(curso);
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
    
    @Override
    public ArrayList<Material> listar_material_tipo_indice(int idCurso ,int tipoMaterial, int indice) {
        ArrayList<Material> materiales = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MATERIAL_TIPO_INDICE(?,?,?)}");
            
            cs.setInt("_idCurso",idCurso);
            cs.setInt("_tipoMaterial",tipoMaterial);
            cs.setInt("_indice_tipoMaterial",indice);
            rs = cs.executeQuery();
            while(rs.next()){
                Material material = new Material();
                material.setIdPost(rs.getInt("idMaterial"));
                
                Curso curso=new Curso();
                curso.setIdCurso(rs.getInt("fidCurso"));
                material.setCurso(curso);
                
                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("fidProfesor"));
                profesor.setNombre(rs.getString("p.nombre"));
                material.setProfesor(profesor);
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("u.nombre"));
                usuario.setApellido(rs.getString("u.apellido"));
                
                material.setSumatoriaCalificaiones(rs.getInt("sumatoriaCalificaciones"));
                material.setCantidadCalificaiones(rs.getInt("cantidadCalificaciones"));
                material.setNombreArchivo(rs.getString("nombreArchivo"));
                           
                
                
                material.setArchivo(rs.getBytes("archivo"));
                
                material.setTipoMaterial(rs.getInt("tipoMaterial"));
                material.setIndice_tipoMaterial(rs.getInt("indice_tipoMaterial"));
                material.setNota(rs.getString("nota"));
                
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

    @Override
    public Material descargar_material(int idMaterial, int idCurso) {
        Material material = new Material();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call DESCARGAR_MATERIAL(?,?)}");
            
            cs.setInt("_idMaterial",idMaterial);
            cs.setInt("_fidCurso", idCurso);
            rs = cs.executeQuery();
             while(rs.next()){
                material.setIdPost(idMaterial);

                Curso curso=new Curso();
                curso.setIdCurso(idCurso);
                material.setCurso(curso);

                Profesor profesor = new Profesor();
                profesor.setIdProfesor(rs.getInt("fidProfesor"));
                
                material.setProfesor(profesor);

                material.setSumatoriaCalificaiones(rs.getInt("sumatoriaCalificaciones"));
                material.setCantidadCalificaiones(rs.getInt("cantidadCalificaciones"));
                material.setNombreArchivo(rs.getString("nombreArchivo"));



                material.setArchivo(rs.getBytes("archivo"));

                material.setTipoMaterial(rs.getInt("tipoMaterial"));
                material.setIndice_tipoMaterial(rs.getInt("indice_tipoMaterial"));
                material.setNota(rs.getString("nota")); 
             }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{ cs.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
            try{ con.close(); }catch(Exception ex){ System.out.println(ex.getMessage()); }
        }
        return material;
    }
  
}
