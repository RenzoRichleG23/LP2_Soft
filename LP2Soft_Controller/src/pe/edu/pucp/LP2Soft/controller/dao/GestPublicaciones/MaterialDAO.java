/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones;

import java.util.ArrayList;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Material;

public interface MaterialDAO {
    int insertar(Material material);
    int modificar(Material material);
    int eliminar(int idMaterial);
    ArrayList<Material> listarTodos();
}