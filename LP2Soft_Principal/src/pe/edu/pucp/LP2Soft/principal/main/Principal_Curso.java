/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.principal.main;

import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

/**
 *
 * @author SANDRO
 */
public class Principal_Curso {
   public static void main(String[] args) {
        Curso c = new Curso("INF282","LENGUAJES DE PROGRAMACION 2",5.00f,"INGENIERIA INFORMATICA",7,"CURSO DE SÉPTIMO CICLO",0,0);
        CursoDAO cDao = new CursoMySQL();
        cDao.insertar(c);
   }
}
