/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.UsuarioMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
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
              //AsesorDAO daoAsesor = new AsesorMySQL();
//            daoAsesor.insertar(asesor, 20186016, 35);    
//            
//            //Listar asesores
//              ArrayList<Usuario> usuariosAsesor = daoAsesor.listarXnombreYcurso("renzo");
//              Usuario user = usuariosAsesor.get(0);
//              System.out.println(user.getNombre());
//              ArrayList<Resenia> resenias = daoAsesor.listarReseniasAsesor(1);
//              Resenia resenia;
//              for(int i=0;i<3;i++){
//                  resenia = resenias.get(i);
//                  System.out.println(resenia.getCalificacion());
//              }
//                Resenia re = new Resenia();
//                re.setCalificacion(5);
//                re.setContenido("Renzo es un capo enseñando");
//                re.setPrioridad(0);
//                Usuario u = new Usuario();
//                Usuario a = new Usuario();
//                u.setIdUsuario(5);
//                a.setIdUsuario(6);
//                re.setUsuario(u);
//                re.setUsuarioReseniado(a);
//                int num = daoAsesor.insertarReseniaAsesor(re);
                //System.out.println(num);
                
                //daoAsesor.eliminarReseniaAsesor(12);
                UsuarioDAO daoUser = new UsuarioMySQL();
                Usuario user = daoUser.recuperarContrasenia("20184024");
                System.out.println(user.getCorreo());
                System.out.println(user.getContrasenia());
                
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}
