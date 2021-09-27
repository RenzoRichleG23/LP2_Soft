/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.principal.main;

import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

public class Principal {
    public static void main(String[] args) {
        Curso c1 = new Curso("INF239","Sistemas Operativos",4.0f,
        "Informática",7,"Curso Complejo",0.0f,0);
        CursoDAO daoCurso = new CursoMySQL();
        daoCurso.insertar(c1);
        System.out.println("Salida con exito");
    }
}
