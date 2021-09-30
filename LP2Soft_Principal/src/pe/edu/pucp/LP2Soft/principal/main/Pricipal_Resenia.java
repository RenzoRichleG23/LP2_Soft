/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ReseniaDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.ReseniaMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

/**
 *
 * @author JOSE
 */
public class Pricipal_Resenia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Profesor profe = new Profesor();
//        profe.setidProfesor(1);
//        
//        Usuario usuario1 = new Usuario();
//        usuario1.setCodigoPUCP(20216008);
//        
//        Usuario usuario2 = new Usuario();
//        usuario2.setCodigoPUCP(20186008);
//        
//        Resenia ej1 = new Resenia(usuario2,2,usuario1,"Buen Profe",profe);
//        
//                
//        ReseniaDAO daoP = new ReseniaMySQL();
//        daoP.insertar(ej1);
        
        
        //modificar
        //ej1.setComentarioPost("Medio Evento");
        //ej1.setIdPost(11);
        //daoP.meodificar(ej1);
        
        //eliminar
        
        //ej1.setIdPost(11);
        //daoP.eliminar(ej1);
        
        //listar
        ArrayList<Resenia> resenias;
        ReseniaDAO daoR = new ReseniaMySQL();
        resenias = daoR.listarTodos();
        
//        resenias.get(0).setComentarioPost("gaaa");
//        daoR.meodificar(resenias.get(0));
//        System.out.println(resenias.get(0).getComentarioPost());
//        
        //eliminar
        daoR.eliminar(resenias.get(0));
    }
    
    
}
