/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.LP2Soft.servlet;

import java.awt.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.LP2Soft.controller.config.DBManager;

/**
 *
 * @author SANDRO
 */
public class ReporteReseniasAsesores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Locale.setDefault(new Locale("es","PE"));
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
            JasperReport reporte = (JasperReport)
                    JRLoader.loadObject(
                ReporteReseniasAsesores.class.getResource(
                                "/pe/edu/pucp/LP2Soft/reportes/ReporteAsesor.jasper"));
            
            String rutaSubReporte = ReporteReseniasAsesores.class.getResource(
                                "/pe/edu/pucp/LP2Soft/reportes/ReporteAlumnos.jasper").getPath();
            rutaSubReporte = rutaSubReporte.replace("%20"," ");
            
            //String rutaImagen = ReporteReseniasAsesores.class.getResource(
                //                "/pe/edu/pucp/LP2Soft/img/infunables.jpg").getPath();
            
            Connection con = DBManager.getInstance().getConnection();
            
            HashMap hm = new HashMap();
            // "/C:/Users/SANDRO/Documents/7mo%20ciclo/lp2/ProyectoFinal/Java/LP2_Soft/LP2Soft_WebService/build/web/WEB-INF/classes/pe/edu/pucp/LP2Soft/reportes/ReporteAlumnos.jasper"
            //Image imagen = (new ImageIcon(rutaImagen)).getImage();
            //hm.put("pImagen",imagen);
            hm.put("idAsesor",1);
            hm.put("rutaSubReporteAlumnos", rutaSubReporte);
            
            JasperPrint jp = JasperFillManager.fillReport(reporte,hm,con);
            
            con.close();
            
            JasperExportManager.exportReportToPdfStream(jp,response.getOutputStream());
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
