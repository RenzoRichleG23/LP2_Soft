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

        Curso c1 = new Curso("INF239","Sistemas Operativos",4.0f,
        "Informática",7,"Curso Complejo",0.0f,0);
        CursoDAO daoCurso = new CursoMySQL();
        daoCurso.insertar(c1);
        System.out.println("Salida con exito");
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // Insertar
            Date fechaN = formato.parse("01-01-2000");
            Usuario u = new Usuario(20216008,"Julanito Gonzales","julanito.g@pucp.edu.pe","Ing. Informática", "julanitoxd", fechaN, "Hola, soy un usuario de pruebas. Soy tu amigo Julanito :D");
            UsuarioDAO usuarioDao = new UsuarioMySQL();
            usuarioDao.insertar(u);
            // Modificar
            Date nuevaFecha = formato.parse("25-11-1999");
            u.setFechaNacimiento(nuevaFecha);
            usuarioDao.modificar(u);
            // Eliminar
            usuarioDao.eliminar(20216008);
            // Listar todos
            ArrayList<Usuario> usuarios = usuarioDao.listarTodos();
            for(Usuario us : usuarios) {
                System.out.println(us.getCodigoPUCP()+ "  " + us.getNombre()+ " - " + formato.format(us.getFechaNacimiento()));
            }
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
