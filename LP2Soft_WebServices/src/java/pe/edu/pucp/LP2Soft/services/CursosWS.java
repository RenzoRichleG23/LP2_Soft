/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;

@WebService(serviceName = "CursosWS")
public class CursosWS {
    private CursoDAO daoCurso;
    public CursosWS(){
        daoCurso  = new CursoMySQL();
    }

    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(@WebParam(name = "idUsuario") int idUsuario){
        ArrayList<Curso> cursos = null;
        cursos = daoCurso.listarCursos(idUsuario);
        return cursos;
    }
    
    @WebMethod(operationName = "MostrarCurso")
    public Curso MostrarCurso(@WebParam(name = "idCurso") int idCurso){
        Curso curso=null;
        curso = daoCurso.MostrarCurso(idCurso);
        return curso;
    }

}
