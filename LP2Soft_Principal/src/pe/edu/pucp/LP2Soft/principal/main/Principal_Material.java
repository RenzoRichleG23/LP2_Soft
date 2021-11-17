/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.ProfesorDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.MaterialDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.ProfesorMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.MaterialMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Material;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;


/**
 *
 * @author Admin
 */
public class Principal_Material {
    public static void main(String[] args) {
        
        /*Material m1=new Material("INF239-2021-2-Prac1_Preg1.pdf","PC1-20212",1);
       
        Usuario usuario = new Usuario();
        usuario.setCodigoPUCP(20216008);
        
        Curso curso = new Curso();
        curso.setCodigo("INF282");
        
        m1.setCurso(curso);
         
        m1.setUsuario(usuario);
        
        MaterialDAO daoMaterial = new MaterialMySQL();
        daoMaterial.insertar(m1);*/
        
//        ArrayList<Material> materiales;
//        MaterialDAO daoMaterial = new MaterialMySQL();
//        materiales=daoMaterial.listarTodos();
//        
//        Material material;
//        material=materiales.get(0);
//        
//        material.setContenido("PC1-20212-P1");
//      
//        daoMaterial.modificar(materiales.get(0));
//        ProfesorDAO daoProfesor = new ProfesorMySQL();
        //daoMaterial.eliminar(material.getIdPost());
//        daoProfesor.listarProfesorXCurso(30);
//        System.out.println("Fin");
           MaterialDAO dao = new MaterialMySQL();
           ArrayList<Material> m = dao.listar_material_tipo_indice(30, 1, 2);
          
        
           
    }
}
