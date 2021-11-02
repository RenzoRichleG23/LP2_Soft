/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.ProfesorDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.ProfesorMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;

/**
 *
 * @author SANDRO
 */
public class Principal_Curso {
   public static void main(String[] args) {
        //Curso c = new Curso("INF282","LENGUAJES DE PROGRAMACION 2",5.00f,"Ing. Informática",7,"CURSO DE SÉPTIMO CICLO",0,0);
        //Curso c2 = new Curso("INF619","LENGUAJES DE PROGRAMACION 2",5.00f,"Ing. Informática",7,"CURSO DE SÉPTIMO CICLO",0,0);
        //CursoDAO cDao = new CursoMySQL();
        //cDao.insertar(c);
        //cDao.insertar(c2);
        //cDao.eliminar("INF619");
        //cDao.eliminar("INF666");
        //ArrayList<Curso> cursos;
        ///CursoDAO daoCurso = new CursoMySQL();
        //cursos=daoCurso.listarTodos();
        //Curso curso;
        ///curso = cursos.get(0);
        //System.out.println(curso.getCodigo());
        //curso.setDescripcion("CURSO DE SEPTIMO CICLO DICTADO POR FREDDY PAZ");
       /// daoCurso.modificar(curso);
//       Profesor p1 = new Profesor(1,"PAZ ESPINIOZA, FREDDY ALBERTO","fpaz@pucp.edu.pe","BUEN PROFESOR DEL CURSO DE LP2");
//       ProfesorDAO pDao = new ProfesorMySQL();
//       //pDao.insertar(p1);
//       pDao.eliminar(1);
       CursoDAO cDao =new  CursoMySQL();
       Curso cursos;
       cursos = cDao.MostrarCurso(28);
       
   }
}
