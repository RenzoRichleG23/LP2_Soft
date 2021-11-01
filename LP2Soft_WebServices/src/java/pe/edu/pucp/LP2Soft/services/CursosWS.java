/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CursosWS")
public class CursosWS {

    /**
     * Aquí van a crearse todos los métodos de acceso para el paquete de Cursos
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
