/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.ProfesorDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.ProfesorMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestCursos.Profesor;

@WebService(serviceName = "CursosWS")
public class CursosWS {
    private CursoDAO daoCurso;
    private ProfesorDAO daoProfesor;
    private AsesorDAO daoAsesor;
    public CursosWS(){
        daoCurso  = new CursoMySQL();
        daoProfesor = new ProfesorMySQL();
        daoAsesor = new AsesorMySQL();
    }
    
    @WebMethod(operationName = "MostrarCurso")
    public Curso MostrarCurso(@WebParam(name = "idCurso") int idCurso){
        Curso curso=null;
        curso = daoCurso.MostrarCurso(idCurso);
        return curso;
    }
    
    @WebMethod(operationName = "listarProfesoresNombre")
    public ArrayList<Profesor> listarProfesoresNombre(@WebParam(name = "nombre") String nombre){
        ArrayList<Profesor> profesores = null;
        profesores = daoProfesor.listarProfesorNombre(nombre);
        return profesores;
    }
    
    @WebMethod(operationName = "mostrarProfesor")
    public Profesor mostrarProfesor(@WebParam(name = "idProfesor") int idProfesor){
        Profesor profesor=null;
        profesor = daoProfesor.mostrarProfesor(idProfesor);
        return profesor;
    }
    
    @WebMethod(operationName = "listarCursosAsesorados")
    public ArrayList<Curso> listarCursosAsesorados(@WebParam(name = "idAsesor") int idAsesor){
        ArrayList<Curso> cursos = null;
        cursos = daoAsesor.listarCursosAsesorados(idAsesor);
        return cursos;
    }
    

}
