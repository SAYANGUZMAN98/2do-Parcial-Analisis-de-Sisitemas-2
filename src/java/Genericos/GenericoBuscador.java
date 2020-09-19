/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genericos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ManuXpy
 */
public class GenericoBuscador {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion conexion;

    public String ListarCalificaciones() throws Mierror {
        String html = "";
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_puntajes, id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno, nombre_asignatura, nombre_carrera FROM public.v_calificaciones ORDER BY id_puntajes;";
            ps = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = ps.executeQuery();
            html += ("<table class=\"table table-hover table-condensed\" id=\"puntajes\"  onclick=\"recuperarBus()\">");
            html += ("<thead>");
            html += ("<tr>");
            html += ("<th>ID Puntaje</th>");
            html += ("<th>ID Alu</th>");
            html += ("<th>COD</th>");
            html += ("<th>Nombre</th>");
            html += ("<th>Apellido</th>");
            html += ("<th>Cedula</th>");
            html += ("<th>Materia</th>");
            html += ("<th>Carrera</th>");
            html += ("</tr>");
            html += ("</thead>");
            html += ("<tbody class=\"buscarG\">");
            while (rs.next()) {
                html += ("<tr>");
                html += ("        <td>" + rs.getInt("id_puntajes") + "</td>");
                html += ("        <td>" + rs.getString("id_alumno") + "</td>");
                html += ("        <td>" + rs.getString("cod_alumno") + "</td>");
                html += ("        <td>" + rs.getString("nombres_alumno") + "</td>");
                html += ("        <td>" + rs.getString("apellidos_alumno") + "</td>");
                html += ("        <td>" + rs.getString("ci_alumno") + "</td>");
                html += ("        <td>" + rs.getString("nombre_asignatura") + "</td>");
                html += ("        <td>" + rs.getString("nombre_carrera") + "</td>");
                html += ("</tr>");
            }
            html += ("</tbody>");
            html += ("</table>");
        } catch (SQLException ex) {
            MsmError = "MI mensaje propio";
            throw new Mierror(MsmError, ex);
        }
        return html;
    }

    public String ListarAlumno() throws Mierror {
        String html = "";
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno  FROM public.t_alumnos ORDER BY id_alumno;";
            ps = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = ps.executeQuery();
            html += ("<table class=\"table table-hover table-condensed\" id=\"Alumno\"  onclick=\"recuperarBus()\">");
            html += ("<thead>");
            html += ("<tr>");
            html += ("<th>ID Alumno</th>");
            html += ("<th>Codigo</th>");
            html += ("<th>Nomnre</th>");
            html += ("<th>Apellido</th>");
            html += ("<th>Cedula</th>");
            html += ("</tr>");
            html += ("</thead>");
            html += ("<tbody class=\"buscarG\">");
            while (rs.next()) {
                html += ("<tr>");
                html += ("        <td>" + rs.getInt("id_alumno") + "</td>");
                html += ("        <td>" + rs.getString("cod_alumno") + "</td>");
                html += ("        <td>" + rs.getString("nombres_alumno") + "</td>");
                html += ("        <td>" + rs.getString("apellidos_alumno") + "</td>");
                html += ("        <td>" + rs.getString("ci_alumno") + "</td>");
                html += ("</tr>");
            }
            html += ("</tbody>");
            html += ("</table>");
        } catch (SQLException ex) {
            MsmError = "MI mensaje propio";
            throw new Mierror(MsmError, ex);
        }
        return html;
    }

}
