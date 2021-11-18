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
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Resenia;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

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
//       CursoDAO cDao =new  CursoMySQL();
//       ArrayList<Curso> cursos;
//       cursos = cDao.listaXciclo(1);
//       
//       ArrayList<Profesor> profesores;
//       ArrayList<Curso> cursos;
//       ProfesorDAO daoProfesor = new ProfesorMySQL();
//       Profesor profesor;
//       Curso curso;
//       profesores = daoProfesor.listarProfesorNombre("llo");
//       cursos = daoProfesor.listarCursoProfesor(8);
//       //profesor = daoProfesor.mostrarProfesor(3);
//       curso = cursos.get(0);
//       System.out.println(curso.getNivel());
//       System.out.println(curso.getIdCurso());
//       System.out.println(curso.getCreditos());
//       System.out.println(curso.getCodigo());
//       System.out.println(curso.getNombre());
         ArrayList<Resenia> resenias;
         ProfesorDAO daoProfesor = new ProfesorMySQL();
         Profesor profesor;
         Resenia resenia;
         Resenia resenia2;
         Usuario usuario;
         usuario = new Usuario();
         resenia = new Resenia();
         resenia2 = new Resenia();
         profesor = new Profesor();
         usuario.setIdUsuario(8);
         profesor.setIdProfesor(16);
         resenia.setCalificacion(4);
         resenia.setPrioridad(1);
         resenia.setProfesor(profesor);
         resenia.setUsuario(usuario);
         resenia.setContenido("Buen profesor");
         daoProfesor.eliminarReseniasProfesor(34);
         
         int resultado;
         
         //resultado = daoProfesor.insertarReseniaProfesor(resenia);
         resenias = daoProfesor.listarReseniasProfesor(1);
         //System.out.println(resultado);
       
   }
}
