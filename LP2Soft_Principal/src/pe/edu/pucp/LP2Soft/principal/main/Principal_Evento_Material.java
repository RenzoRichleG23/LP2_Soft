/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.EventoDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.EventoMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Evento;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

/**
 *
 * @author Admin
 */
public class Principal_Evento_Material {
    public static void main(String[] args) {
        /*SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Evento e1=null;
        try{
            e1=new Evento(formato.parse("20-10-2021"),"tallerBD.jpg","Taller de Base de Datos",1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        Usuario usuario = new Usuario();
        usuario.setCodigoPUCP(20216008);
         
        e1.setUsuario(usuario);
        
        EventoDAO daoEvento = new EventoMySQL();
        daoEvento.insertar(e1);*/
        
        ArrayList<Evento> eventos;
        EventoDAO daoEvento = new EventoMySQL();
        eventos=daoEvento.listarTodos();
        
        Evento evento;
        evento=eventos.get(0);
        
        //evento.setComentarioPost("Fiesta de bienvenida a los cachimbos 2022");
      
        //daoEvento.modificar(eventos.get(0));
        daoEvento.eliminar(evento.getIdPost());
        
        System.out.println("Fin");
    }
}
