/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AccesoDAO;
import DAOIMPL.AccesoDAOIMPL;
import DTO.AccesoDTO;
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
 * @author !mX
 */
public class AccesoServlet extends HttpServlet {

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

        AccesoDAO acceso = new AccesoDAOIMPL();
        AccesoDTO accesoDTO = new AccesoDTO();

        accesoDTO.setUsuario(request.getParameter("username"));
        accesoDTO.setPass(request.getParameter("password"));

        if (acceso.verificarUsuario(accesoDTO)) {
            HttpSession sessionActiva = request.getSession();
            String UsuarioLogueado = accesoDTO.getUsuario();
            String UsuarioRol = "0";
            sessionActiva.setAttribute("sessionON", UsuarioLogueado);
            sessionActiva.setAttribute("sessionROL", UsuarioRol);

            response.sendRedirect("/Calificaciones/inicio.jsp");
            System.out.println("verificacion exitosa de usuario");

        } else {
            response.sendRedirect("/Calificaciones/login.html");
            System.out.println("error al verificar el usuario");
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
            Logger.getLogger(AccesoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccesoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
