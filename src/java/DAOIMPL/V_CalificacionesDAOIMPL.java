/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.V_CalificacionesDAO;
import DTO.V_CalificacionesDTO;
import Genericos.Conexion;
import com.google.gson.Gson;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author !mX
 */
public class V_CalificacionesDAOIMPL implements V_CalificacionesDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;

    @Override
    public String getV_Calificaciones() {
        ResultSet rs;
        ArrayList<V_CalificacionesDTO> allCalificaciones = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();

            sintaxiSql = "SELECT id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, nombre_asignatura, \n"
                    + "       t_asignatura_id_asignatura, nombre_carrera, t_alumnos_id_alumno, \n"
                    + "       t_carreras_id_carrera, id_asignatura, t_anho_id_anho, puntaje_tp, \n"
                    + "       puntaje_ep, puntaje_ef, puntaje_total, id_carrera, ci_alumno, \n"
                    + "       fecha_nac_alumno\n"
                    + "  FROM v_calificaciones;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allCalificaciones.add(new V_CalificacionesDTO(rs.getInt("id_alumno"),
                        rs.getInt("cod_alumno"),
                        rs.getString("nombres_alumno"),
                        rs.getString("apellidos_alumno"),
                        rs.getString("nombre_asignatura"),
                        rs.getString("nombre_carrera"),
                        rs.getInt("t_alumnos_id_alumno"),
                        rs.getInt("t_carreras_id_carrera"),
                        rs.getInt("id_asignatura"),
                        rs.getInt("t_anho_id_anho"),
                        rs.getInt("puntaje_tp"),
                        rs.getInt("puntaje_ep"),
                        rs.getInt("puntaje_ef"),
                        rs.getInt("puntaje_total"),
                        rs.getInt("id_carrera"),
                        rs.getString("ci_alumno"),
                        rs.getDate("fecha_nac_alumno")));

            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(allCalificaciones);

    }

    @Override
    public Integer getAlumnos() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_alumno),0 ) as codigo  FROM t_alumnos;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return 0;
    }

    @Override
    public Integer getCarreras() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_carrera),0 ) as codigo  FROM t_carreras;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return 0;
    }

    @Override
    public Integer getMaterias() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_asignatura),0 ) as codigo  FROM t_asignatura;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return 0;
    }

}
