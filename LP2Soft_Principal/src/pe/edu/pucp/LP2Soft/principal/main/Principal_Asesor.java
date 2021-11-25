/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
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
            CursoDAO _daoCurso = new CursoMySQL();
            ArrayList<Curso> cursos = _daoCurso.listarCursosPostular();
            for(int i=0;i<20;i++){
                Curso curso = cursos.get(i);
                System.out.println(curso.getNombre());
            }
                
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");
    }
}
