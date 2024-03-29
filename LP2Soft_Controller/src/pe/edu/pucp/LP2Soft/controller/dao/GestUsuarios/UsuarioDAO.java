/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.PostGenerico;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

//xd
public interface UsuarioDAO {
    int insertar(Usuario u);
    int modificar(Usuario u);
    int eliminar(int idUsuario);
    ArrayList<Usuario> listarNombreCodigo(String nombreCodigo);
    Usuario mostrar(String correoCodigo, int isCode);
    ArrayList<Usuario> listarAmigosNombreCodigo(int idUsuario, String nombreCodigo);
    int hacerAdmin(int idUsuario);
    int agregarAmigo(int idUsuario1, int idUsuario2);
    int eliminarAmigo(int idUsuario1, int idUsuario2);
    int esAmigo(int idUsuario1, int idUsuario2);
    Usuario recuperarContrasenia(String codigoPUCP);
    int modificarContrasenia(int idUsuario, String newPassword);
}
