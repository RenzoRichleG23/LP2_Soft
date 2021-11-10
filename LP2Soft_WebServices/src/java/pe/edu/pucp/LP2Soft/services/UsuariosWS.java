/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.AsesorDAO;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.AsesorMySQL;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.UsuarioMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Asesor;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

@WebService(serviceName = "UsuariosWS")
public class UsuariosWS {
    private UsuarioDAO daoUsuario;
    private AsesorDAO daoAsesor;
    private CursoDAO daoCurso;
    
    public UsuariosWS() {
        daoUsuario = new UsuarioMySQL();
        daoAsesor = new AsesorMySQL();
        daoCurso  = new CursoMySQL();
    }

    @WebMethod(operationName = "mostrarUsuario")
    public Usuario mostrarUsuario(@WebParam(name = "correoCodigo") String correoCodigo,
            @WebParam(name = "isCode") int isCode) {
        Usuario usuario = daoUsuario.mostrar(correoCodigo, isCode);
        return usuario;
    }
    
    @WebMethod(operationName = "insertarUsuario")
    public int insertarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        int resultado = daoUsuario.insertar(usuario);
        return resultado;
    }
    
    @WebMethod(operationName = "listarUsuariosNombreCodigo")
    public ArrayList<Usuario> listarUsuariosNombreCodigo(@WebParam(name = "nombreCodigo") String nombreCodigo) {
        ArrayList<Usuario> usuarios = null;
        usuarios = daoUsuario.listarNombreCodigo(nombreCodigo);
        return usuarios;
    }
    
    @WebMethod(operationName = "esAmigo")
    public int esAmigo(@WebParam(name = "idUsuario1") int idUsuario1,
            @WebParam(name = "idUsuario2") int idUsuario2) {
        int resultado = daoUsuario.esAmigo(idUsuario1, idUsuario2);
        return resultado;
    }
    
    @WebMethod(operationName = "agregarAmigo")
    public int agregarAmigo(@WebParam(name = "idUsuario1") int idUsuario1,
            @WebParam(name = "idUsuario2") int idUsuario2) {
        int resultado = daoUsuario.agregarAmigo(idUsuario1, idUsuario2);
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarAmigo")
    public int eliminarAmigo(@WebParam(name = "idUsuario1") int idUsuario1,
            @WebParam(name = "idUsuario2") int idUsuario2) {
        int resultado = daoUsuario.eliminarAmigo(idUsuario1, idUsuario2);
        return resultado;
    }
    
    @WebMethod(operationName = "hacerAdmin")
    public int hacerAdmin(@WebParam(name = "idUsuario") int idUsuario) {
        int resultado = daoUsuario.hacerAdmin(idUsuario);
        return resultado;
    }
    
    @WebMethod(operationName = "modificarUsuario")
    public int modificarUsuario(@WebParam(name = "usuario") Usuario usuario) {
        int resultado = daoUsuario.modificar(usuario);
        return resultado;
    }
    
    @WebMethod(operationName = "listarAmigosNombreCodigo")
    public ArrayList<Usuario> listarAmigosNombreCodigo(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "nombreCodigo") String nombreCodigo) {
        ArrayList<Usuario> usuarios = null;
        usuarios = daoUsuario.listarAmigosNombreCodigo(idUsuario,nombreCodigo);
        return usuarios;
    }
    
    @WebMethod(operationName = "insertarAsesor")
    public int insertarAsesor(@WebParam(name = "asesor") Asesor asesor, 
            @WebParam(name = "fidUsuario") int fidUsuario,
            @WebParam(name = "fidCurso") int fidCurso) {    
        int resultado = daoAsesor.insertar(asesor, fidUsuario, fidCurso);
        return resultado;
    }
    
    @WebMethod(operationName = "listarXnombreYcurso")
    public ArrayList<Usuario> listarXnombreYcurso(@WebParam(name = "nombre") String nombre) {
        ArrayList<Usuario> usuarios = null;
        usuarios = daoAsesor.listarXnombreYcurso(nombre);
        return usuarios;
    }
    
    @WebMethod(operationName = "listarCursos")
    public ArrayList<Curso> listarCursos(@WebParam(name = "idUsuario") int idUsuario){
        ArrayList<Curso> cursos = null;
        cursos = daoCurso.listarCursos(idUsuario);
        return cursos;
    }
}
