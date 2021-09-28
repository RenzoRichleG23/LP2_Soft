/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.MaterialDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.MaterialMySQL;
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
         
        m1.setUsuario(usuario);
        
        MaterialDAO daoMaterial = new MaterialMySQL();
        daoMaterial.insertar(m1);*/
        
        ArrayList<Material> materiales;
        MaterialDAO daoMaterial = new MaterialMySQL();
        materiales=daoMaterial.listarTodos();
        
        Material material;
        material=materiales.get(0);
        
        //material.setComentarioPost("PC1-20212-P1");
      
        //daoMaterial.modificar(materiales.get(0));
        
        daoMaterial.eliminar(material.getIdPost());
        
        System.out.println("Fin");
    }
}
