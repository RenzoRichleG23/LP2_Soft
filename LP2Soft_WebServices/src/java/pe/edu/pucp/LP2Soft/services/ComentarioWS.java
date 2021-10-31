/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.LP2Soft.controller.dao.GestPublicaciones.ComentarioDAO;
import pe.edu.pucp.LP2Soft.controller.mysql.GestPublicaciones.ComentarioMySQL;
import pe.edu.pucp.LP2Soft.model.GestPublicaciones.Comentario;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "ComentarioWS")
public class ComentarioWS {

    private ComentarioDAO daoComentario;
    
    public ComentarioWS() {
        daoComentario = new ComentarioMySQL();
    }
    
    @WebMethod(operationName = "insertarComentario")
    public int insertarComentario(@WebParam(name = "comentario") Comentario comentario) {
        int resultado = daoComentario.insertar(comentario);
        return resultado;
    }
}