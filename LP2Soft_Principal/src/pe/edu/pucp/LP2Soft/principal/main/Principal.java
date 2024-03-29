/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.principal.main;

import pe.edu.pucp.LP2Soft.controller.dao.GestCursos.CursoDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestCursos.CursoMySQL;
import pe.edu.pucp.LP2Soft.model.GestCursos.Curso;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import pe.edu.pucp.LP2Soft.model.GestUsuarios.Usuario;
import java.util.Date;
import pe.edu.pucp.LP2Soft.controller.dao.GestUsuarios.UsuarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestUsuarios.UsuarioMySQL;
public class Principal {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            CursoDAO dao = new CursoMySQL();
            dao.listarCursos(5);
            // Insertar
//            Date fechaN = formato.parse("01-01-2000");
//            Usuario u = new Usuario();
//            u.setIdUsuario(20186098);
//            u.setApellido("Oswald");
//            u.setNombre("Alfonso");
//            u.setContrasenia("alfonso123");
//            u.setCorreo("juan@pucp.edu.pe");
//            u.setEspecialidad("Ing. Informática");
//            u.setDescripcion("Gaaaaa! Alguien a vista a mi amix Juliana... nahh mejor hago el trabajo o me va a pegar :(");
//            u.setCodigoPUCP("23456789");
//            u.setFechaNacimiento(fechaN);
//            UsuarioDAO usuarioDao = new UsuarioMySQL();
//            int resultado = usuarioDao.modificar(u);
//            System.out.println("el resultado del insert es:" + resultado);
            // Modificar
//            Date nuevaFecha = formato.parse("25-11-1999");
//            u.setFechaNacimiento(nuevaFecha);
//            usuarioDao.modificar(u);
            // Eliminar
//            usuarioDao.eliminar(20216008);
            // Listar todos
//            ArrayList<Usuario> usuarios = usuarioDao.listarTodos();
//            for(Usuario us : usuarios) {
//                System.out.println(us.getCodigoPUCP()+ "  " + us.getNombre()+ " - " + formato.format(us.getFechaNacimiento()));
//            }
            // Mostrar
//            Usuario us = usuarioDao.mostrar(20186008, "oscaar20186008");
//            if(us!=null)
//                System.out.println(us.getCodigoPUCP()+ "  " + us.getNombre()+ " - " + formato.format(us.getFechaNacimiento()));
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Programa Finalizado con exito!");

    }
    
}
