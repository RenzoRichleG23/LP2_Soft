/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

/**
 *
 * @author USER
 */
public class Principal_Asesor {
    public static void main(String[] args) {
        try {
            // INSERTAR
//            Asesor asesor = new Asesor();
//            asesor.setIdAsesor(1);
//            asesor.setActivo(true);
//            asesor.setCalificacion(4);        
//            asesor.setPrecioPorHora(30);
//            
            AsesorDAO daoAsesor = new AsesorMySQL();
//            daoAsesor.insertar(asesor, 20186022, 20);    
            
            //Listar asesores
            ArrayList<Usuario> usuariosAsesor = daoAsesor.listarXnombreYcurso("renzo");
            Usuario user = usuariosAsesor.get(0);
            System.out.println(user.getNombre());
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}
