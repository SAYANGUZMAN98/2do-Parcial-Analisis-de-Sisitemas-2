/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PuntajesDAO;
import DAOIMPL.PuntajesDAOIMPL;
import DTO.PuntajesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author !mX
 */
public class PuntajesServlet extends HttpServlet {

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
        response.setContentType("application/json, charset=UTF-8");

        PrintWriter out = response.getWriter();
        Integer opcion = Integer.parseInt(request.getParameter("opcion"));

        PuntajesDAO puntajes = new PuntajesDAOIMPL();
        PuntajesDTO puntajesDTO = new PuntajesDTO();

        switch (opcion) {
            case 1:
                puntajesDTO.setId_puntajes(Integer.parseInt(request.getParameter("codigo")));
                puntajesDTO.setT_alumnos_id_alumno(Integer.parseInt(request.getParameter("codigoAlu")));
                puntajesDTO.setT_asignatura_id_asignatura(Integer.parseInt(request.getParameter("materia")));
                puntajesDTO.setT_anho_id_anho(Integer.parseInt(request.getParameter("anho")));
                puntajesDTO.setPuntaje_tp(request.getParameter("tp"));
                puntajesDTO.setPuntaje_ep(request.getParameter("ep"));
                puntajesDTO.setPuntaje_ef(request.getParameter("final"));
                puntajesDTO.setPuntaje_total(request.getParameter("total"));
                puntajesDTO.setId_usuario(request.getParameter("usuario"));
                if (puntajes.insertar(puntajesDTO)) {
                    System.out.println("Mensaje del Servler...Insert Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Insert Error");
                }

                break;
            case 2:
                puntajesDTO.setId_puntajes(Integer.parseInt(request.getParameter("codigo")));
                puntajesDTO.setT_alumnos_id_alumno(Integer.parseInt(request.getParameter("codigoAlu")));
                puntajesDTO.setT_asignatura_id_asignatura(Integer.parseInt(request.getParameter("materia")));
                puntajesDTO.setT_anho_id_anho(Integer.parseInt(request.getParameter("anho")));
                puntajesDTO.setPuntaje_tp(request.getParameter("tp"));
                puntajesDTO.setPuntaje_ep(request.getParameter("ep"));
                puntajesDTO.setPuntaje_ef(request.getParameter("final"));
                puntajesDTO.setPuntaje_total(request.getParameter("total"));
                puntajesDTO.setId_usuario(request.getParameter("usuario"));
                if (puntajes.modificar(puntajesDTO)) {
                    System.out.println("Mensaje del Servler...Update Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Update Error");
                }

                break;
            case 3:
                if (puntajes.eliminar(Integer.parseInt(request.getParameter("codigo")))) {
                    System.out.println("Mensaje del Servler...Delete Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Delete Error");
                }

                break;
            case 4:
                if (puntajes.getUltimoCodigo() > 0) {
                    out.println(puntajes.getUltimoCodigo());
                    System.out.println("Mensaje del Servler... Recuperar ultimo codigo Exitoso");
                }
                break;
            case 5:
                if (puntajes.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))) != null) {
                    out.println(puntajes.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))));
                    System.out.println("Mensaje del Servler...recuperacion de filtro Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Error al recuperar filtro");
                }
                break;
            case 6:
                if (puntajes.FiltroID(Integer.parseInt(request.getParameter("codigoAlu"))) != null) {
                    out.println(puntajes.FiltroID(Integer.parseInt(request.getParameter("codigoAlu"))));
                    System.out.println("Mensaje del Servler...recuperacion de filtro Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Error al recuperar filtro");
                }
                break;
            case 7:
                out.println(puntajes.ComboCarreras());
                break;
            case 8:
                out.println(puntajes.ComboMaterias());
                break;
            case 9:
                out.println(puntajes.ComboAno());
                break;
            case 10:
                out.println(puntajes.ComboUsuario());
                break;
            case 11:
                out.println(puntajes.allSeleccion());
                break;
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
