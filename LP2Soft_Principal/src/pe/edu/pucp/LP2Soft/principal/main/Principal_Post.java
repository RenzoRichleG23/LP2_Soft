/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.PostDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.PostMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Post;
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
        
        
        Post ej1 = new Post("Nuevo Evento");
        Usuario usuario = new Usuario();
        usuario.setCodigoPUCP(20216008);
        ej1.setUsuario(usuario);
        
        PostDAO daoP = new PostMySQL();
        //daoP.insertar(ej1);
        
        
        //modificar
        ej1.setContenido("Medio Evento");
        ej1.setIdPost(11);
        //daoP.meodificar(ej1);
        
        //eliminar
        
        ej1.setIdPost(11);
        //daoP.eliminar(ej1);
        
        //listar
        ArrayList<Post> posts;
        posts = daoP.listarTodos();
        
        System.out.println(posts.get(3).getContenido());
    }
    
}