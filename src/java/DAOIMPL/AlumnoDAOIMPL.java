/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.AlumnoDAO;
import DTO.AlumnoDTO;
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
public class AlumnoDAOIMPL implements AlumnoDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;
    private int filasAfectadas;

    @Override
    public boolean insertar(AlumnoDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "INSERT INTO t_alumnos(id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno, fecha_nac_alumno) VALUES (?, ?, ?, ?, ?, ?::date);";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getId_alumno());
            preparedStatement.setObject(2, dto.getCod_alumno());
            preparedStatement.setObject(3, dto.getNombres_alumno());
            preparedStatement.setObject(4, dto.getApellidos_alumno());
            preparedStatement.setObject(5, dto.getCi_alumno());
            preparedStatement.setObject(6, dto.getFecha_nac_alumno());

            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el insert se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el insert tuvo un fallo");
                return false;
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;
        }

    }

    @Override
    public boolean modificar(AlumnoDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "UPDATE public.t_alumnos SET  cod_alumno=?, nombres_alumno=?, apellidos_alumno=?, ci_alumno=?, fecha_nac_alumno=?::date WHERE id_alumno=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getCod_alumno());
            preparedStatement.setObject(2, dto.getNombres_alumno());
            preparedStatement.setObject(3, dto.getApellidos_alumno());
            preparedStatement.setObject(4, dto.getCi_alumno());
            preparedStatement.setObject(5, dto.getFecha_nac_alumno());
            preparedStatement.setObject(6, dto.getId_alumno());
            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el UPDATE se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el UPDATE tuvo un fallo");
                return false;
            }

        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;

        }

    }

    @Override
    public boolean eliminar(Integer idDto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "DELETE FROM t_alumnos WHERE id_alumno = ?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, idDto);
            filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                conexion.comit();
                out.println("el Delete se realizo con exito");
                return true;
            } else {
                conexion.rollback();
                out.println("el Delete tuvo un fallo");
                return false;
            }

        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);
            return false;

        }

    }

    @Override
    public String allSeleccion() {
        ResultSet rs;
        ArrayList<AlumnoDTO> allAlumnos = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno, fecha_nac_alumno FROM t_alumnos ORDER BY id_alumno;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allAlumnos.add(new AlumnoDTO(rs.getInt("id_alumno"),
                        rs.getInt("cod_alumno"),
                        rs.getString("nombres_alumno"),
                        rs.getString("apellidos_alumno"),
                        rs.getString("ci_alumno"),
                        rs.getString("fecha_nac_alumno")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(allAlumnos);
    }

    @Override
    public String allFiltroSeleccion(Integer idFiltro) {
        ResultSet rs;
        ArrayList<AlumnoDTO> alumnno = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_alumno, cod_alumno, nombres_alumno, apellidos_alumno, ci_alumno, fecha_nac_alumno FROM public.t_alumnos WHERE id_alumno=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                alumnno.add(new AlumnoDTO(rs.getInt("id_alumno"),
                        rs.getInt("cod_alumno"),
                        rs.getString("nombres_alumno"),
                        rs.getString("apellidos_alumno"),
                        rs.getString("ci_alumno"),
                        rs.getString("fecha_nac_alumno")));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            MsmError = "MI mensaje propio";

        }
        return new Gson().toJson(alumnno);
    }

    @Override
    public Integer getUltimoCodigo() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_alumno),0 )+ 1 as codigo  FROM t_alumnos;";
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
