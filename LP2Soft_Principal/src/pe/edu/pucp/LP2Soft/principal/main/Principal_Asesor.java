/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
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
//            asesor.setIdAsesor(22);
//            asesor.setActivo(true);
//            asesor.setCalificacion(4);        
//            asesor.setPrecioPorHora(30);
//            
              AsesorDAO daoAsesor = new AsesorMySQL();
//            daoAsesor.insertar(asesor, 20186016, 35);    
//            
//            //Listar asesores
//            ArrayList<Usuario> usuariosAsesor = daoAsesor.listarXnombreYcurso("renzo");
//            Usuario user = usuariosAsesor.get(0);
//            System.out.println(user.getNombre());
              ArrayList<Curso> cursos = daoAsesor.listarCursosAsesorados(8);
              Curso curso;
              for(int i=0;i<3;i++){
                  curso = cursos.get(i);
                  System.out.println(curso.getNombre());
              }
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}
