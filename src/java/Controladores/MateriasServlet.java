/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.MateriasDAO;
import DAOIMPL.MateriasDAOIMPL;
import DTO.MateriasDTO;
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
public class MateriasServlet extends HttpServlet {

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

        MateriasDAO materias = new MateriasDAOIMPL();
        MateriasDTO materiasDTO = new MateriasDTO();

        switch (opcion) {
            case 1:
                materiasDTO.setId_asignatura(Integer.parseInt(request.getParameter("codigo")));
                materiasDTO.setNombre_asignatura(request.getParameter("materia"));
                materiasDTO.setT_carreras_id_carrera(Integer.parseInt(request.getParameter("carrera")));
                if (materias.insertar(materiasDTO)) {
                    System.out.println("Mensaje del Servler...Insert Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Insert Error");
                }
                break;
            case 2:
                materiasDTO.setId_asignatura(Integer.parseInt(request.getParameter("codigo")));
                materiasDTO.setNombre_asignatura(request.getParameter("materia"));
                materiasDTO.setT_carreras_id_carrera(Integer.parseInt(request.getParameter("carrera")));
                if (materias.modificar(materiasDTO)) {
                    System.out.println("Mensaje del Servler...UPDATE Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...UPDATE Exitoso");
                }
                break;
            case 3:
                if (materias.eliminar(Integer.parseInt(request.getParameter("codigo")))) {
                    System.out.println("Mensaje del Servler...Delete Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Delete Error");
                }
                break;
            case 4:
                out.println(materias.allSeleccion());
                break;
            case 5:
                if (materias.getUltimoCodigo() > 0) {
                    out.println(materias.getUltimoCodigo());
                    System.out.println("Mensaje del Servler... Recuperar ultimo codigo Exitoso");
                }
                break;
            case 6:
                if (materias.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))) != null) {
                    out.println(materias.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))));
                    System.out.println("Mensaje del Servler...recuperacion de filtro Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Error al recuperar filtro");
                }
                break;
            case 7:
                out.println(materias.ComboCarreras());
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
