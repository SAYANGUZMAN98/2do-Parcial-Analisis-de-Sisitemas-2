/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOIMPL;

import DAO.CarrerasDAO;
import DTO.CarrerasDTO;
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
public class CarrerasDAOIMPL implements CarrerasDAO {

    private String sintaxiSql;
    private String MsmError;
    private PreparedStatement preparedStatement;
    private ResultSet resultado;
    private Conexion conexion;
    private int filasAfectadas;

    @Override
    public boolean insertar(CarrerasDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "INSERT INTO public.t_carreras(id_carrera, nombre_carrera) VALUES (?, ?);";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(1, dto.getId_carrera());
            preparedStatement.setObject(2, dto.getNombre_carrera());

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
    public boolean modificar(CarrerasDTO dto) {
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "UPDATE public.t_carreras SET nombre_carrera=? WHERE id_carrera=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setObject(2, dto.getId_carrera());
            preparedStatement.setObject(1, dto.getNombre_carrera());
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
            sintaxiSql = "DELETE FROM public.t_carreras WHERE id_carrera= ?;";
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
        ArrayList<CarrerasDTO> allcarreras = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_carrera, nombre_carrera FROM public.t_carreras ORDER BY id_carrera;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                allcarreras.add(new CarrerasDTO(rs.getInt("id_carrera"),
                        rs.getString("nombre_carrera")));
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(allcarreras);
    }

    @Override
    public String allFiltroSeleccion(Integer idFiltro) {
        ResultSet rs;
        ArrayList<CarrerasDTO> carreras = new ArrayList<>();
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT id_carrera, nombre_carrera FROM public.t_carreras WHERE id_carrera=?;";
            preparedStatement = conexion.getConexion().prepareStatement(sintaxiSql);
            preparedStatement.setInt(1, idFiltro);

            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                carreras.add(new CarrerasDTO(rs.getInt("id_carrera"),
                        rs.getString("nombre_carrera")));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            MsmError = ex.getMessage();
            out.println(MsmError);

        }
        return new Gson().toJson(carreras);
    }

    @Override
    public Integer getUltimoCodigo() {
        ResultSet rs;
        try {
            sintaxiSql = null;
            conexion = new Conexion();
            sintaxiSql = "SELECT coalesce(max(id_carrera),0 )+ 1 as codigo  FROM t_carreras;";
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
