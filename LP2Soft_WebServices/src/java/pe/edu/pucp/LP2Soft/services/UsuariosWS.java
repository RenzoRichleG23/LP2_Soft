/**
 * @author INFunables Group
 */

package pe.edu.pucp.LP2Soft.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.UsuarioMySQL;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

@WebService(serviceName = "UsuariosWS")
public class UsuariosWS {
    private UsuarioDAO daoUsuario;
    
    public UsuariosWS() {
        daoUsuario = new UsuarioMySQL();
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
}
