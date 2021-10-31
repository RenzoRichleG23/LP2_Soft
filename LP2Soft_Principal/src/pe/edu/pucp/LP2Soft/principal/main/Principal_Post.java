/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.PostMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

/**
 *
 * @author JOSE
 */
public class Principal_Post {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dt = new Date();
        PostGenerico ej1 = new PostGenerico();
//        Usuario usuario = new Usuario();
//        usuario.setIdUsuario(20186019);
//        ej1.setUsuario(usuario);
//        ej1.setContenido("Hola");
//        try{
//            ej1.setFechaRegistro(formato.parse(formato.format(dt)));
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        ej1.setPrioridad(2);
//        
        PostDAO daoP = new PostMySQL();
//        System.out.println(formato.format(dt));
//        daoP.insertar(ej1);
//        
//        
//        //modificar
//        ej1.setContenido("Medio Evento");
//        ej1.setIdPost(11);
//        //daoP.meodificar(ej1);
//        
//        //eliminar
//        
//        ej1.setIdPost(11);
//        //daoP.eliminar(ej1);
//        
//        //listar
        ArrayList<PostGenerico> posts;
        posts = daoP.listarTodos();
        
//        for(PostGenerico p : posts){
//            
//        }
//        
        System.out.println(posts.get(2).getIdPost());
    }
    
}