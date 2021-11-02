/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;

/**
 *
 * @author USER
 */
public class Principal_Asesor {
    public static void main(String[] args) {
        try {
            // INSERTAR
            Asesor asesor = new Asesor();
            asesor.setIdAsesor(1);
            asesor.setActivo(true);
            asesor.setCalificacion(4);        
            asesor.setPrecioPorHora(20);
            
            AsesorDAO daoAsesor = new AsesorMySQL();
            daoAsesor.insertar(asesor, 20186022, 40);          
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}
