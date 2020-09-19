/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.AlumnoDAO;
import DAOIMPL.AlumnoDAOIMPL;
import DTO.AlumnoDTO;
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
public class AlumnosServlet extends HttpServlet {

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

        AlumnoDAO alumnos = new AlumnoDAOIMPL();
        AlumnoDTO alumnosDTO = new AlumnoDTO();

        switch (opcion) {
            case 1:
                alumnosDTO.setId_alumno(Integer.parseInt(request.getParameter("codigo")));
                alumnosDTO.setCod_alumno(Integer.parseInt(request.getParameter("codigo2")));
                alumnosDTO.setNombres_alumno(request.getParameter("nonbre"));
                alumnosDTO.setApellidos_alumno(request.getParameter("apellido"));
                alumnosDTO.setCi_alumno(request.getParameter("cedula"));
                alumnosDTO.setFecha_nac_alumno(request.getParameter("fechanac"));
                if (alumnos.insertar(alumnosDTO)) {
                    System.out.println("Mensaje del Servler...Insert Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Insert Error");
                }
                break;
            case 2:
                alumnosDTO.setId_alumno(Integer.parseInt(request.getParameter("codigo")));
                alumnosDTO.setCod_alumno(Integer.parseInt(request.getParameter("codigo2")));
                alumnosDTO.setNombres_alumno(request.getParameter("nonbre"));
                alumnosDTO.setApellidos_alumno(request.getParameter("apellido"));
                alumnosDTO.setCi_alumno(request.getParameter("cedula"));
                alumnosDTO.setFecha_nac_alumno(request.getParameter("fechanac"));
                if (alumnos.modificar(alumnosDTO)) {
                    System.out.println("Mensaje del Servler...UPDATE Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...UPDATE Exitoso");
                }
                break;
            case 3:
                if (alumnos.eliminar(Integer.parseInt(request.getParameter("codigo")))) {
                    System.out.println("Mensaje del Servler...Delete Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Delete Error");
                }
                break;
            case 4:
                out.println(alumnos.allSeleccion());
                break;
            case 5:
                if (alumnos.getUltimoCodigo() > 0) {
                    out.println(alumnos.getUltimoCodigo());
                    System.out.println("Mensaje del Servler... Recuperar ultimo codigo Exitoso");
                }
                break;
            case 6:
                if (alumnos.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))) != null) {
                    out.println(alumnos.allFiltroSeleccion(Integer.parseInt(request.getParameter("codigo"))));
                    System.out.println("Mensaje del Servler...recuperacion de filtro Exitoso");
                } else {
                    System.out.println("Mensaje del Servler...Error al recuperar filtro");
                }
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
