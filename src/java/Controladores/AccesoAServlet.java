/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
//

import DAO.AccesoADAO;
import DAOIMPL.AccesoADAOIMPL;
import DTO.AlumnoDTO;
import Genericos.Mierror;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ManuXpy
 */
public class AccesoAServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws Genericos.Mierror
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Mierror {

        AccesoADAO acceso = new AccesoADAOIMPL();
        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setCi_alumno(request.getParameter("ci"));
        alumnoDTO.setFecha_nac_alumno(request.getParameter("fecha"));


        if (acceso.verificarUsuario(alumnoDTO)) {
            HttpSession sessionActiva = request.getSession();
            String UsuarioLogueado = alumnoDTO.getCi_alumno();
            sessionActiva.setAttribute("sessionON", UsuarioLogueado);
            response.sendRedirect("/Calificaciones/consulta.jsp");
            System.out.println("verificacion exitosa de alumno");
        } else {
            response.sendRedirect("/Calificaciones/LoginAlumnos.html");
            System.out.println("error al verificar el alumno");
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
        try {
            processRequest(request, response);
        } catch (Mierror ex) {
            Logger.getLogger(AccesoAServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Mierror ex) {
            Logger.getLogger(AccesoAServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
