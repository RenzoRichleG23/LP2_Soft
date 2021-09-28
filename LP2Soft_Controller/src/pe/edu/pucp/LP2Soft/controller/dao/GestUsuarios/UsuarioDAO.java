/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;

public interface UsuarioDAO {
    int insertar(Usuario u);
    int modificar(Usuario u);
    int eliminar(int idUsuario);
    ArrayList<Usuario> listarTodos();
    Usuario mostrar(int codigoPUCP, String password);
}
